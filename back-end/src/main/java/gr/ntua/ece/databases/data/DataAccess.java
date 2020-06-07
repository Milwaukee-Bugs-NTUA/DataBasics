package gr.ntua.ece.databases.data;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Date;
import java.time.LocalDate;
import java.time.DayOfWeek;
import java.util.List;
import java.util.StringJoiner;
import org.restlet.data.Status;
import org.restlet.resource.ResourceException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
        if (!(startingDate.equals(Date.valueOf("0000-01-01"))) && !(endingDate.equals(Date.valueOf("0000-01-01")))) {
            joiner.add("date(tr.datetime) between \'" + startingDate.toString() + "\' and \'" + endingDate.toString() + "\'");
        }
        if (!(paymentMethod.equals("any"))) {
            joiner.add("tr.payment_method = \'" + paymentMethod + "\'");
        }

        String sqlQueryForTransactions = joiner.toString() + 
                                        " group by tr.datetime,tr.card_number ";

        if ((!(numOfProductsLow == 0)) && (!(numOfProductsHigh == 0))) {
            sqlQueryForTransactions = sqlQueryForTransactions + " having count(*) between "
                                        + numOfProductsLow.toString() + " and "
                                        + numOfProductsHigh.toString();
        }
        else if (!(numOfProductsLow == 0)) {
            sqlQueryForTransactions = sqlQueryForTransactions + " having count(*) >= "
                                        + numOfProductsLow.toString();
        }
        else if (!(numOfProductsHigh == 0)) {
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
                                    "from users order by first_name,last_name";
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
        System.out.println(lastMonday + lastSunday);
        Object[] sqlParamsForMeanTrsPerWeek = new Object[]{"2018-01-16", "2019-06-17", userId}; //Hard Coded for now

        String sqlQueryForCommonProducts = "select c.product_id, p.name from contains as c, " +
                                            "products as p " + 
                                            "where c.product_id = p.barcode and c.card_number = ? " +
                                            "group by c.product_id order by sum(c.pieces) desc limit 10";
        String sqlQueryForCommonStores = "select distinct tr.purchased_from as common_store, " +
                                            "s.address_city as name from transactions as tr, stores as s "+
                                            "where tr.purchased_from = s.store_id and card_number = ?";
        String sqlQueryForHappyHours = "select hour(datetime) as time_field, count(*) " +
                                        "from transactions where card_number = ? " +
                                        "group by time_field";
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

            List<HappyHour> happyHours;
            happyHours = jdbcTemplate.query(sqlQueryForHappyHours, sqlParamsForUser, (ResultSet rs, int rowNum) -> {
                HappyHour dataload = new HappyHour();
                dataload.setHour(rs.getInt(1));
                dataload.setCount(rs.getInt(2));
                return dataload;
            });
            userInfo.setHappyHours(happyHours);

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
}