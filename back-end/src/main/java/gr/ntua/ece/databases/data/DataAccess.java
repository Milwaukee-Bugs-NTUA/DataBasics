package gr.ntua.ece.databases.data;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.DayOfWeek;
import java.util.List;
import java.util.StringJoiner;
import org.restlet.data.Status;
import org.restlet.resource.ResourceException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.lang.Math;
import java.util.Random;

import gr.ntua.ece.databases.data.model.*;

public class DataAccess {

    private static final Object[] EMPTY_ARGS = new Object[0];

    private static final int MAX_TOTAL_CONNECTIONS = 16;
    private static final int MAX_IDLE_CONNECTIONS = 8;

    private JdbcTemplate jdbcTemplate;

    public void setup(String driverClass, String url, String user, String pass) throws SQLException {

        //initialize the data source
        BasicDataSource bds = new BasicDataSource();
        bds.setDriverClassName(driverClass);
        bds.setUrl(url);
        bds.setMaxTotal(MAX_TOTAL_CONNECTIONS);
        bds.setMaxIdle(MAX_IDLE_CONNECTIONS);
        bds.setUsername(user);
        bds.setPassword(pass);
        bds.setValidationQuery("SELECT 1");
        bds.setTestOnBorrow(true);
        bds.setDefaultAutoCommit(true);

        //check that everything works OK
        bds.getConnection().close();

        //initialize the jdbc template utility
        jdbcTemplate = new JdbcTemplate(bds);
    }

    public void accessDataCheck() throws DataAccessException {
        try {
            System.out.println("Reached to DataAccess");
            jdbcTemplate.query("select 1", ResultSet::next);
        } catch (Exception e) {
            throw new DataAccessException(e.getMessage(), e);
        }
    }

    public List<Store> fetchStores() throws DataAccessException {

        String sqlQueryForStores = "select store_id,address_city from stores order by store_id";
        List<Store> results;

        try {
            results = jdbcTemplate.query(sqlQueryForStores, (ResultSet rs, int rowNum) -> {
                Store dataload = new Store();
                dataload.setStoreID(rs.getLong(1));
                dataload.setAddressCity(rs.getString(2));
                return dataload;
            });

            return results;
        } 
        
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DataAccessException(e.getMessage(), e);
        }
    }

    public List<Transaction> fetchTransactions(Long storeId,
                                                Date startingDate,
                                                Date endingDate,
                                                String paymentMethod,
                                                Integer numOfProductsLow,
                                                Integer numOfProductsHigh) throws DataAccessException {

        String sqlQueryFirstPart = "select tr.*,count(*) as count " +
                                            "from " + 
                                            "(select datetime,card_number,total_cost,payment_method,address_city " +
                                                "from transactions, stores " + 
                                                "where purchased_from=store_id " +
                                                "and purchased_from = ?) as tr, contains as c " +
                                            "where (tr.datetime,tr.card_number) = (c.datetime,c.card_number) ";
        
        Object[] sqlParamsForTransactions = new Object[]{storeId};

        StringJoiner joiner = new StringJoiner(" and ");
        joiner.add(sqlQueryFirstPart);
        if (!(startingDate == null) && !(endingDate == null)) {
            joiner.add("date(tr.datetime) between \'" + startingDate.toString() + "\' and \'" + endingDate.toString() + "\'");
        }
        else if (startingDate != null) {
            joiner.add("date(tr.datetime) >= \'" + startingDate.toString() + "\'");
        }
        else if (endingDate != null) {
            joiner.add("date(tr.datetime) <= \'" + endingDate.toString() + "\'");
        }
        if (!(paymentMethod.equals("any"))) {
            joiner.add("tr.payment_method = \'" + paymentMethod + "\'");
        }

        String sqlQueryForTransactions = joiner.toString() + 
                                        " group by tr.datetime,tr.card_number ";

        if ((!(numOfProductsLow == null)) && (!(numOfProductsHigh == null))) {
            sqlQueryForTransactions = sqlQueryForTransactions + " having count(*) between "
                                        + numOfProductsLow.toString() + " and "
                                        + numOfProductsHigh.toString();
        }
        else if (!(numOfProductsLow == null)) {
            sqlQueryForTransactions = sqlQueryForTransactions + " having count(*) >= "
                                        + numOfProductsLow.toString();
        }
        else if (!(numOfProductsHigh == null)) {
            sqlQueryForTransactions = sqlQueryForTransactions + " having count(*) <= "
                                        + numOfProductsHigh.toString();

        }

        sqlQueryForTransactions = sqlQueryForTransactions + " order by tr.total_cost";
        
        List<Transaction> results;

        try {
            results = jdbcTemplate.query(sqlQueryForTransactions, sqlParamsForTransactions, (ResultSet rs, int rowNum) -> {
                Transaction dataload = new Transaction();
                dataload.setDatetime(rs.getTimestamp(1));
                dataload.setCardNumber(rs.getLong(2));
                dataload.setTotalCost(rs.getFloat(3));
                dataload.setPaymentMethod(rs.getString(4));
                dataload.setPurchasedFrom(rs.getString(5));
                dataload.setNumberOfProducts(rs.getInt(6));
                return dataload;
            });

            return results;
        } 
        
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DataAccessException(e.getMessage(), e);
        }
    }

    public List<TransactionProduct> fetchTransactionProducts(Timestamp datetime, Long cardNumber) throws DataAccessException {
        String sqlQueryForTransactionProducts = "select p.barcode,p.name,p.brand_name,c.pieces " +
                                                "from contains as c, products as p " +
                                                "where c.product_id = p.barcode " +
                                                "and c.card_number = ? " +
                                                "and c.datetime = ? " +
                                                "order by p.name";

        Object[] sqlParamsForTransactionProducts = new Object[]{cardNumber, datetime.toString()};
        List<TransactionProduct> results;
        try {
            results = jdbcTemplate.query(sqlQueryForTransactionProducts, sqlParamsForTransactionProducts, (ResultSet rs, int rowNum) -> {
                TransactionProduct dataload = new TransactionProduct();
                dataload.setBarcode(rs.getLong(1));
                dataload.setProductName(rs.getString(2));
                dataload.setBrandName(rs.getString(3));
                dataload.setPieces(rs.getInt(4));
                return dataload;
            });
            return results;
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DataAccessException(e.getMessage(), e);
        }
    }

    public Store fetchStorePage(Long storeId) throws DataAccessException {

        Object[] sqlParamsForStore = new Object[]{storeId};

        String sqlQueryForStore = "select * from stores where store_id = ?";

        try {
            Store store = jdbcTemplate.queryForObject(sqlQueryForStore, sqlParamsForStore, (ResultSet rs, int rowNum) -> {
                Store dataload = new Store();
                dataload.setStoreID(rs.getLong(1));
                dataload.setSize(rs.getInt(2));
                dataload.setAddressCity(rs.getString(3));
                dataload.setAddressStreet(rs.getString(4));
                dataload.setAddressNumber(rs.getInt(5));
                dataload.setAddressPostalCode(rs.getString(6));
                dataload.setOpeningHour(rs.getTime(7));
                dataload.setClosingHour(rs.getTime(8));
                return dataload;
            });

            return store;
        } 
        
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DataAccessException(e.getMessage(), e);
        }
    }

    public List<User> fetchUsers() throws DataAccessException {

        String sqlQueryForUsers = "select card_number,first_name,last_name,email " + 
                                    "from users order by card_number";
        List<User> results;

        try {
            results = jdbcTemplate.query(sqlQueryForUsers, (ResultSet rs, int rowNum) -> {
                User dataload = new User();
                dataload.setCardNumber(rs.getLong(1));
                dataload.setFirstName(rs.getString(2));
                dataload.setLastName(rs.getString(3));
                dataload.setEmail(rs.getString(4));
                return dataload;
            });

            return results;
        } 
        
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DataAccessException(e.getMessage(), e);
        }
    }

    public User fetchUserProfile(Long userId) throws DataAccessException {

        Object[] sqlParamsForUser = new Object[]{userId};

        String sqlQueryForUser = "select * from users where card_number = ?";

        try {
            User user = jdbcTemplate.queryForObject(sqlQueryForUser, sqlParamsForUser, (ResultSet rs, int rowNum) -> {
                User dataload = new User();
                dataload.setCardNumber(rs.getLong(1));
                dataload.setEmail(rs.getString(2));
                dataload.setFirstName(rs.getString(3));
                dataload.setLastName(rs.getString(4));
                dataload.setDateOfBirth(rs.getDate(5));
                dataload.setSex(rs.getString(6));
                dataload.setAddressStreet(rs.getString(7));
                dataload.setAddressNumber(rs.getInt(8));
                dataload.setAddressPostalCode(rs.getString(9));
                dataload.setAddressCity(rs.getString(10));
                dataload.setPhoneNumber(rs.getString(11));
                dataload.setMaritalStatus(rs.getString(12));
                dataload.setNumberOfChildren(rs.getInt(13));
                dataload.setPoints(rs.getInt(14));
                return dataload;
            });

            return user;
        } 
        
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DataAccessException(e.getMessage(), e);
        }
    }

    public UserInfo fetchUserInfo(Long userId) throws DataAccessException {

        Object[] sqlParamsForUser = new Object[]{userId};
        LocalDate localDate = LocalDate.now();
        LocalDate lastDate = localDate.minusMonths(1);
        int lastMonth = lastDate.getMonthValue();
        int lastYear = lastDate.getYear();
        Object[] sqlParamsForMeanTrsPerMonth = new Object[]{1, 2018, userId}; //Hard Coded for now

        LocalDate dateOfLastWeek = localDate.minusDays(7);
        int dayOfLastWeek = dateOfLastWeek.getDayOfWeek().getValue();
        String lastMonday = dateOfLastWeek.minusDays(dayOfLastWeek - 1).toString();
        String lastSunday = dateOfLastWeek.plusDays(7 - dayOfLastWeek).toString();
        Object[] sqlParamsForMeanTrsPerWeek = new Object[]{lastMonday,lastSunday, userId}; //Hard Coded for now

        String sqlQueryForCommonProducts = "select c.product_id, p.name, p.brand_name from contains as c, " +
                                            "products as p " + 
                                            "where c.product_id = p.barcode and c.card_number = ? " +
                                            "group by c.product_id order by sum(c.pieces) desc limit 10";
        String sqlQueryForCommonStores = "select distinct tr.purchased_from as common_store, " +
                                            "s.address_city as name from transactions as tr, stores as s "+
                                            "where tr.purchased_from = s.store_id and card_number = ?";
        // String sqlQueryForHappyHours = "select hour(datetime) as time_field, count(*) " +
        //                                 "from transactions where card_number = ? " +
        //                                 "group by time_field";
        String sqlQueryForMeanTrsPerWeek = "select cast(avg(total_cost) as decimal(7,2)) as mean " +
                                            "from transactions " +
                                            "where date(datetime) between ? and ? " +
                                            "and card_number = ?";
        String sqlQueryForMeanTrsPerMonth = "select cast(avg(total_cost) as decimal(7, 2)) as mean " +
                                                "from transactions where month(datetime) = ? " + 
                                                "and year(datetime) = ? and card_number = ? " +
                                                "group by month(datetime)";

        UserInfo userInfo = new UserInfo();

        try {
            List<CommonProduct> commonProducts;
            commonProducts = jdbcTemplate.query(sqlQueryForCommonProducts, sqlParamsForUser, (ResultSet rs, int rowNum) -> {
                CommonProduct dataload = new CommonProduct();
                dataload.setBarcode(rs.getLong(1));
                dataload.setProductName(rs.getString(2));
                dataload.setBrandName(rs.getString(3));
                return dataload;
            });
            userInfo.setCommonProducts(commonProducts);

            List<CommonStore> commonStores;
            commonStores = jdbcTemplate.query(sqlQueryForCommonStores, sqlParamsForUser, (ResultSet rs, int rowNum) -> {
                CommonStore dataload = new CommonStore();
                dataload.setStoreID(rs.getLong(1));
                dataload.setStoreName(rs.getString(2));
                return dataload;
            });
            userInfo.setCommonStores(commonStores);

            // List<HappyHour> happyHours;
            // happyHours = jdbcTemplate.query(sqlQueryForHappyHours, sqlParamsForUser, (ResultSet rs, int rowNum) -> {
            //     HappyHour dataload = new HappyHour();
            //     dataload.setHour(rs.getInt(1));
            //     dataload.setCount(rs.getInt(2));
            //     return dataload;
            // });
            // userInfo.setHappyHours(happyHours);

            Float meanTrsPerWeek;
            meanTrsPerWeek = jdbcTemplate.queryForObject(sqlQueryForMeanTrsPerWeek, sqlParamsForMeanTrsPerWeek, (ResultSet rs, int rowNum) -> {
                Float dataload = rs.getFloat(1);
                return dataload;
            });
            if (meanTrsPerWeek == null) {
                userInfo.setMeanTransactionsPerWeek(Float.valueOf(0));
            }
            else {
                userInfo.setMeanTransactionsPerWeek(meanTrsPerWeek);
            }

            Float meanTrsPerMonth;
            meanTrsPerMonth = jdbcTemplate.queryForObject(sqlQueryForMeanTrsPerMonth, sqlParamsForMeanTrsPerMonth, (ResultSet rs, int rowNum) -> {
                Float dataload = rs.getFloat(1);
                return dataload;
            });
            if (meanTrsPerMonth == null) {
                userInfo.setMeanTransactionsPerMonth(Float.valueOf(0));
            }
            else {
                userInfo.setMeanTransactionsPerMonth(meanTrsPerMonth);
            }

            return userInfo;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DataAccessException(e.getMessage(), e);
        }
    }

    public List<Product> fetchProducts() throws DataAccessException {

        String sqlQueryForProducts = "select barcode,name,brand_name,price from products order by barcode";
        List<Product> results;

        try {
            results = jdbcTemplate.query(sqlQueryForProducts, (ResultSet rs, int rowNum) -> {
                Product dataload = new Product();
                dataload.setBarcode(rs.getLong(1));
                dataload.setName(rs.getString(2));
                dataload.setBrandName(rs.getString(3));
                dataload.setPrice(rs.getFloat(4));
                return dataload;
            });

            return results;
        } 
        
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DataAccessException(e.getMessage(), e);
        }
    }

    public Product fetchProduct(Long barcode) throws DataAccessException {

        Object[] sqlParamsForProduct = new Object[]{barcode};

        String sqlQueryForProduct = "select prd.barcode, prd.name, prd.brand_name, " + 
                                        "prd.price, prd.category as category_id, " +
                                        "c.name as category_name from products as prd, product_category as c " +
                                        "where prd.category = c.category_id and prd.barcode = ?";

        try {
            Product product = jdbcTemplate.queryForObject(sqlQueryForProduct, sqlParamsForProduct, (ResultSet rs, int rowNum) -> {
                Product dataload = new Product();
                dataload.setBarcode(rs.getLong(1));
                dataload.setName(rs.getString(2));
                dataload.setBrandName(rs.getString(3));
                dataload.setPrice(rs.getFloat(4));
                dataload.setCategoryId(rs.getLong(5));
                dataload.setCategoryName(rs.getString(6));
                return dataload;
            });

            return product;
        } 
        
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DataAccessException(e.getMessage(), e);
        }
    }

    public List<PriceHistory> fetchPriceHistory(Long barcode) throws DataAccessException {

        Object[] sqlParamsForPriceHistory = new Object[]{barcode};
        String sqlQueryForPriceHistory = "select barcode, starting_date, ending_date, old_price " +
                                            "from price_history where barcode = ? order by starting_date desc";
        List<PriceHistory> results;

        try {
            results = jdbcTemplate.query(sqlQueryForPriceHistory, sqlParamsForPriceHistory, (ResultSet rs, int rowNum) -> {
                PriceHistory dataload = new PriceHistory();
                dataload.setBarcode(rs.getLong(1));
                dataload.setStartingDate(rs.getTimestamp(2));
                dataload.setEndingDate(rs.getTimestamp(3));
                dataload.setOldPrice(rs.getFloat(4));
                return dataload;
            });

            return results;
        } 
        
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DataAccessException(e.getMessage(), e);
        }
    }

    public ProductsStatistics fetchProductsStatistics() throws DataAccessException {

        String sqlQueryForTopProductsPairs =    "with cont as " +
                                                    "(select product_id,name,brand_name,datetime,card_number " +
                                                    "from contains as c,products as p " +
                                                    "where c.product_id = p.barcode) " +
                                                "select c1.product_id as b1,c1.name as name1, " +
                                                        "c1.brand_name as brand1,c2.product_id as b2, " +
                                                        "c2.name as name2,c2.brand_name as brand2 " +
                                                "from cont as c1, cont as c2 " +
                                                "where (c1.datetime,c1.card_number) = (c2.datetime,c2.card_number) " +
                                                "and c1.product_id < c2.product_id " +
                                                "group by b1,b2 " +
                                                "order by count(*) desc " +
                                                "limit 5";
        
        String sqlQueryForTopPlacements = "select alley_number,shelf_number " +
                                            "from offers " +
                                            "group by alley_number,shelf_number " +
                                            "order by count(*) desc limit 5";
        
        String sqlQueryForDatastoreSales = "with total_sales_per_product as " +
                                            "(select p.barcode,p.brand_name,p.category as category_id,cat.name as category,sum(c.pieces) as pieces " +
                                            "from contains as c,products as p, product_category as cat " +
                                            "where c.product_id = p.barcode " +
                                            "and p.category = cat.category_id " + 
                                            "group by p.barcode), " +
                                            "total_sales as " +
                                            "(select tsp.category_id, tsp.category,sum(tsp.pieces) as sales " +
                                            "from total_sales_per_product as tsp " +
                                            "group by tsp.category_id), " +
                                            "total_sales_datastore as " +
                                            "(select tsp.category_id,tsp.category,sum(tsp.pieces) as sales " +
                                            "from total_sales_per_product as tsp " +
                                            "where tsp.brand_name = \'Datastore\' " +
                                            "group by tsp.category_id) " +
                                            "select t.category_id,t.category,ifnull(cast((d.sales/t.sales)*100 as decimal(5,2)),0) as percentage " +
                                            "from total_sales_datastore as d " +
                                            "right join total_sales as t using(category_id) " +
                                            "order by t.category_id";

        ProductsStatistics productsStatistics = new ProductsStatistics();

        try {
            List<ProductsPair> productsPairsList;
            productsPairsList = jdbcTemplate.query(sqlQueryForTopProductsPairs, (ResultSet rs, int rowNum) -> {
                ProductsPair dataload = new ProductsPair();
                dataload.setBarcode1(rs.getLong(1));
                dataload.setProductName1(rs.getString(2));
                dataload.setBrandName1(rs.getString(3));
                dataload.setBarcode2(rs.getLong(4));
                dataload.setProductName2(rs.getString(5));
                dataload.setBrandName2(rs.getString(6));
                return dataload;
            });
            productsStatistics.setTopProductsPairs(productsPairsList);

            List<ProductPlacement> productsPlacementsList;
            productsPlacementsList = jdbcTemplate.query(sqlQueryForTopPlacements, (ResultSet rs, int rowNum) -> {
                ProductPlacement dataload = new ProductPlacement();
                dataload.setAlleyNumber(rs.getString(1));
                dataload.setSelfNumber(rs.getString(2));
                return dataload;
            });
            productsStatistics.setTopProductsPlacements(productsPlacementsList);

            List<PercentageOfSuccess> percentageList;
            percentageList = jdbcTemplate.query(sqlQueryForDatastoreSales, (ResultSet rs, int rowNum) -> {
                PercentageOfSuccess dataload = new PercentageOfSuccess();
                dataload.setCategoryId(rs.getLong(1));
                dataload.setCategoryName(rs.getString(2));
                dataload.setPercentage(rs.getFloat(3));
                return dataload;
            });
            productsStatistics.setPercentageOfSuccessInEachCategory(percentageList);

            return productsStatistics;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DataAccessException(e.getMessage(), e);
        }
    }

    public UsersStatistics fetchUsersStatistics() throws DataAccessException {

        String sqlQueryForMaximumSalesHourZone =   "with r as " +
                                                    "(select hour(datetime) as hour_zone,sum(total_cost) as money_spend " +
                                                    "from transactions " +
                                                    "group by hour_zone " +
                                                    "order by money_spend) " +
                                                    "select r.hour_zone " +
                                                    "from r left join " +
                                                    "(select distinct r1.hour_zone,r1.money_spend " +
                                                    "from r as r1, r as r2 " +
                                                    "where r1.money_spend < r2.money_spend) as s using(hour_zone) " +
                                                    "where s.money_spend is null";
        
        String sqlQueryForPercentagesPerHourZone = "with r as " +
                                                    "(select u.card_number, " +
                                                    "timestampdiff(year,u.date_of_birth,curdate()) as age, " +
                                                    "hour(t.datetime) as hour_zone " +
                                                    "from users as u " +
                                                    "join transactions as t using(card_number)), " +
                                                    "young as " +
                                                    "(select hour_zone, count(*) as trs " +
                                                    "from r " +
                                                    "where r.age between 15 and 34 " +
                                                    "group by r.hour_zone " +
                                                    "order by hour_zone), " +
                                                    "middle as " +
                                                    "(select hour_zone, count(*) as trs " +
                                                    "from r " +
                                                    "where r.age between 35 and 60 " +
                                                    "group by r.hour_zone " +
                                                    "order by hour_zone), " +
                                                    "elderly as " +
                                                    "(select hour_zone, count(*) as trs " +
                                                    "from r " +
                                                    "where r.age >= 61 " +
                                                    "group by r.hour_zone " +
                                                    "order by hour_zone), " +
                                                    "total as " +
                                                    "(select hour_zone, count(*) as trs " +
                                                    "from r " +
                                                    "group by r.hour_zone " +
                                                    "order by hour_zone) " +
                                                    "select hour_zone, " +
                                                    "cast((ifnull(y.trs,0)/t.trs)*100 as decimal(5,2)) as young_p, " +
                                                    "cast((ifnull(m.trs,0)/t.trs)*100 as decimal(5,2)) as middle_p, " +
                                                    "cast((ifnull(e.trs,0)/t.trs)*100 as decimal(5,2)) as elderly_p " +
                                                    "from total as t " +
                                                    "left join young as y using(hour_zone) " +
                                                    "left join middle as m using(hour_zone) " +
                                                    "left join elderly as e using(hour_zone)";

        UsersStatistics usersStatistics = new UsersStatistics();

        try {

            Integer hourZoneWithMaximumSales = jdbcTemplate.queryForObject(sqlQueryForMaximumSalesHourZone, (ResultSet rs, int rowNum) -> {
                                                Integer dataload = rs.getInt(1);
                                                return dataload;
                                                });
            usersStatistics.setMaximumSalesHourZone(hourZoneWithMaximumSales);
            
            List<PercentagesPerHour> percentagesPerHourZone;
            percentagesPerHourZone = jdbcTemplate.query(sqlQueryForPercentagesPerHourZone, (ResultSet rs, int rowNum) -> {
                PercentagesPerHour dataload = new PercentagesPerHour();
                dataload.setHourZone(rs.getInt(1));
                dataload.setPercentageofYoung(rs.getFloat(2));
                dataload.setPercentageofMiddle(rs.getFloat(3));
                dataload.setPercentageofElder(rs.getFloat(4));
                return dataload;
            });
            usersStatistics.setPercentagesPerHour(percentagesPerHourZone);

            return usersStatistics;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DataAccessException(e.getMessage(), e);
        }
    }

    public void addStore(
                            Integer size, 
                            String addressCity,
                            String addressStreet,
                            Integer addressNumber,
                            String addressPostalCode,
                            Time openingHour,
                            Time closingHour
                        ) throws DataAccessException {

        Object[] sqlParamsForStore = new Object[]   {
                                                        size,
                                                        addressCity,
                                                        addressStreet,
                                                        addressNumber,
                                                        addressPostalCode,
                                                        openingHour.toString(),
                                                        closingHour.toString()
                                                    };

        String sqlQueryForStore = "insert into stores " +
                                    "(size,address_city,address_street,address_number, " + 
                                    "address_postalcode,opening_hour,closing_hour) " + 
                                    " values " + 
                                    "(?,?,?,?,?,?,?)";

        try {
            jdbcTemplate.update(sqlQueryForStore, sqlParamsForStore);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DataAccessException(e.getMessage(), e);
        }
    }

    public void addUser(
                            String email,
                            String firstName,
                            String lastName,    
                            Date dateOfBirth,
                            String sex,
                            String city,
                            String street,
                            Integer streetNumber,
                            String postalCode,
                            String phone,
                            String maritalStatus,
                            Integer numberOfChildren,
                            Integer points
                        ) throws DataAccessException {

        Object[] sqlParamsForUser = new Object[]   {
                                                        email,
                                                        firstName,
                                                        lastName,    
                                                        dateOfBirth.toString(),
                                                        sex,
                                                        city,
                                                        street,
                                                        streetNumber,
                                                        postalCode,
                                                        phone,
                                                        maritalStatus,
                                                        Integer.toString(numberOfChildren),
                                                        Integer.toString(points)
                                                    };

        String sqlQueryForUser = "insert into users " +
                                    "(email,first_name,last_name,date_of_birth,sex,address_city,address_street,address_number, " + 
                                    "address_postal_code,phone_number,marital_status,number_of_children,points) " + 
                                    " values " + 
                                    "(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            jdbcTemplate.update(sqlQueryForUser, sqlParamsForUser);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DataAccessException(e.getMessage(), e);
        }
    }

    public void addProduct(
                            String name,
                            String brand,
                            Float price,
                            Long categoryId,
                            Long offeredInStore,
                            String alleyNumber,
                            String shelfNumber
                        ) throws DataAccessException {

        Object[] sqlParamsForProduct = new Object[] {
            name,
            brand,    
            price.toString(),
            categoryId
        };

        String sqlQueryForProduct = "insert into products " +
                                    "(name,brand_name,price,category) " + 
                                    " values " + 
                                    "(?,?,?,?)";

        try {
            jdbcTemplate.update(sqlQueryForProduct, sqlParamsForProduct);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DataAccessException(e.getMessage(), e);
        }

        String sqlQueryForBarcode = "select barcode from products " +
                                    "where name = ? and brand_name = ?";
        Object[] sqlParamsForBarcode = new Object[] {name,brand};
        Long barcode;

        try {
            barcode = jdbcTemplate.queryForObject(sqlQueryForBarcode,sqlParamsForBarcode, (ResultSet rs, int rowNum) -> {
                return rs.getLong(1);
            });
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DataAccessException(e.getMessage(), e);
        }

        String sqlQueryForAvailability = "insert into offers " +
                                            "(product_id,store_id,alley_number,shelf_number) " +
                                            " values " +
                                            "(?,?,?,?)";
        Object[] sqlParamsForAvailability = new Object[] {
            barcode,
            offeredInStore,
            alleyNumber,
            shelfNumber
        };

        try {
            jdbcTemplate.update(sqlQueryForAvailability, sqlParamsForAvailability);   
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DataAccessException(e.getMessage(), e);
        }
    }

    public void updateProduct(Long barcode,String name,String brandName,Long categoryId) throws DataAccessException {

        Object[] sqlParamsForProduct = new Object[] {name,brandName,categoryId,barcode};

        String sqlQueryForProduct = "update products " + 
                                    "set name = ?,brand_name = ?,category = ? " +
                                    "where barcode = ?";

        try {
            jdbcTemplate.update(sqlQueryForProduct, sqlParamsForProduct);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DataAccessException(e.getMessage(), e);
        }
    }

    public void updateUserProfile(
                                    Long cardNumber,
                                    String email,
                                    String firstName,
                                    String lastName,
                                    Date dateOfBirth,
                                    String sex,
                                    String addressCity,
                                    String addressStreet,
                                    Integer addressNumber,
                                    String addressPostalCode,
                                    String phoneNumber,
                                    String maritalStatus,
                                    Integer numberOfChildren,
                                    Integer points
                                ) throws DataAccessException {

        Object[] sqlParamsForUser = new Object[] {
            email,
            firstName,
            lastName,
            dateOfBirth.toString(),
            sex,
            addressCity,
            addressStreet,
            addressNumber,
            addressPostalCode,
            phoneNumber,
            maritalStatus,
            numberOfChildren,
            points,
            cardNumber
        };

        String sqlQueryForUser = "update users " + 
                                    "set email = ?, " +
                                    "first_name = ?, " +
                                    "last_name = ?, " +
                                    "date_of_birth = ?, " +
                                    "sex = ?, " +
                                    "address_city = ?, " +
                                    "address_street = ?, " +
                                    "address_number = ?, " +
                                    "address_postal_code = ?, " +
                                    "phone_number = ?, " +
                                    "marital_status = ?, " +
                                    "number_of_children = ?, " +
                                    "points = ? " +
                                    "where card_number = ?";

        try {
            jdbcTemplate.update(sqlQueryForUser, sqlParamsForUser);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DataAccessException(e.getMessage(), e);
        }
    }

    public void updateStore(
                                Long storeId,
                                Integer size,
                                String addressCity,
                                String addressStreet,
                                Integer addressNumber,
                                String addressPostalCode,
                                Time openingHour,
                                Time closingHour
                            ) throws DataAccessException {

        Object[] sqlParamsForStore = new Object[] {
            size,
            addressCity,
            addressStreet,
            addressNumber,
            addressPostalCode,
            openingHour.toString(),
            closingHour.toString(),
            storeId
        };

        String sqlQueryForStore = "update stores " + 
                                    "set size = ?, " +
                                    "address_city = ?, " +
                                    "address_street = ?, " +
                                    "address_number = ?, " +
                                    "address_postalcode = ?, " +
                                    "opening_hour = ?, " +
                                    "closing_hour = ? " +
                                    "where store_id = ?";

        try {
            jdbcTemplate.update(sqlQueryForStore, sqlParamsForStore);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DataAccessException(e.getMessage(), e);
        }
    }

    public void updateProductPrice(Long barcode,Float price) throws DataAccessException {

        Object[] sqlParamsForProduct = new Object[] {barcode};

        String sqlQueryForProduct = "select starting_sale_date,price from products " +
                                    "where barcode = ?";

        LocalDateTime currentTimestamp = LocalDateTime.now();
        PriceHistory priceHistory;

        try {
            priceHistory = jdbcTemplate.queryForObject(sqlQueryForProduct, sqlParamsForProduct, (ResultSet rs, int rowNum) -> {
                PriceHistory dataload = new PriceHistory();
                dataload.setBarcode(barcode);
                dataload.setStartingDate(rs.getTimestamp(1));
                dataload.setOldPrice(rs.getFloat(2));
                dataload.setEndingDate(Timestamp.valueOf(currentTimestamp));
                return dataload;
            });
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DataAccessException(e.getMessage(), e);
        }

        Object[] sqlParamsForPriceHistory = new Object[] { 
            priceHistory.getStartingDate().toString(),
            priceHistory.getBarcode(),
            priceHistory.getEndingDate().toString(),
            String.valueOf(priceHistory.getOldPrice())
        };
        String sqlQueryForPriceHistory = "insert into price_history " +
                                            "(starting_date,barcode,ending_date,old_price) " +
                                            "values " +
                                            "(?,?,?,?)";

        try {
            jdbcTemplate.update(sqlQueryForPriceHistory, sqlParamsForPriceHistory);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DataAccessException(e.getMessage(), e);
        }

        Object[] sqlParamsForNewPrice = new Object[] {
            price,
            currentTimestamp.toString(),
            barcode
        };
        String sqlQueryForNewPrice = "update products " +
                                        "set price = ?,starting_sale_date = ? " +
                                        "where barcode = ?";

        try {
            jdbcTemplate.update(sqlQueryForNewPrice, sqlParamsForNewPrice);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DataAccessException(e.getMessage(), e);
        }

    }

    public void deleteUser(Long userId) throws DataAccessException {

        Object[] sqlParamsForUser = new Object[] {userId};

        String sqlQueryForUser = "delete from users where card_number = ?";

        try {
            jdbcTemplate.update(sqlQueryForUser, sqlParamsForUser);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DataAccessException(e.getMessage(), e);
        }
    }

    public void deleteStore(Long storeId) throws DataAccessException {

        Object[] sqlParamsForStore = new Object[] {storeId};

        String sqlQueryForStore = "delete from stores where store_id = ?";

        try {
            jdbcTemplate.update(sqlQueryForStore, sqlParamsForStore);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DataAccessException(e.getMessage(), e);
        }
    }

    public void deleteProduct(Long barcode) throws DataAccessException {

        Object[] sqlParamsForProduct = new Object[] {barcode};

        String sqlQueryForProduct = "delete from products where barcode = ?";

        try {
            jdbcTemplate.update(sqlQueryForProduct, sqlParamsForProduct);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DataAccessException(e.getMessage(), e);
        }
    }

    public void generatePriceHistoryDataFrom() throws DataAccessException {

        String sqlQueryForProducts = "select barcode,price,starting_sale_date from products";
        String sqlQueryForUpdate = "insert into price_history "+
                                    "(starting_date,barcode,ending_date,old_price) "+
                                    "values " +
                                    "(?,?,?,?)";
        List<Product> currentProducts;

        try {
            // Fetch current prices
            currentProducts = jdbcTemplate.query(sqlQueryForProducts, (ResultSet rs, int rowNum) -> {
                Product dataload = new Product();
                dataload.setBarcode(rs.getLong(1));
                dataload.setPrice(rs.getFloat(2));
                dataload.setStartingSaleDatetime(rs.getTimestamp(3));
                return dataload;
            });
            // Update priceHistory Table for each product
            for (Product pr: currentProducts) {
                Long barcode = pr.getBarcode();
                LocalDateTime end = pr.getStartingSaleDatetime().toLocalDateTime();
                Float currentPrice = pr.getPrice();
                // Insert 100 records
                for (int i = 0; i < 10; i++) {
                    Float oldPrice = currentPrice + ((float) Math.random()*2)*((new Random()).nextBoolean() ? -1 : 1);
                    LocalDateTime start = end.minusDays(7);
                    Object[] sqlParamsForUpdate = new Object[] {
                        (Timestamp.valueOf(start)).toString(),
                        barcode,
                        (Timestamp.valueOf(end)).toString(),
                        oldPrice.toString()
                    };
                    jdbcTemplate.update(sqlQueryForUpdate, sqlParamsForUpdate);
                    end = start;                     
                }
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DataAccessException(e.getMessage(), e);
        }
    }
}