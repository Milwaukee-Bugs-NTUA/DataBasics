package gr.ntua.ece.databases.data;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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

    public User fetchUserProfile(Long userId) throws DataAccessException {

        Object[] sqlParamsForUser = new Object[]{userId};

        String sqlQueryForUser = "select * from users where card_number = ?";

        try {
            User user = jdbcTemplate.queryForObject(sqlQueryForUser, sqlParamsForUser, (ResultSet rs, int rowNum) -> {
                User dataload = new User();
                dataload.setCardNumber(rs.getLong(1));
                dataload.setEmail(rs.getString(2));
                dataload.setFirstName(rs.getString(4));
                dataload.setLastName(rs.getString(5));
                dataload.setDateOfBirth(rs.getDate(6));
                dataload.setSex(rs.getString(7));
                dataload.setAddressStreet(rs.getString(8));
                dataload.setAddressNumber(rs.getInt(9));
                dataload.setAddressPostalCode(rs.getString(10));
                dataload.setAddressCity(rs.getString(11));
                dataload.setPhoneNumber(rs.getString(12));
                dataload.setMaritalStatus(rs.getString(13));
                dataload.setNumberOfChildren(rs.getInt(14));
                dataload.setPoints(rs.getInt(15));
                return dataload;
            });

            return user;
        } 
        
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DataAccessException(e.getMessage(), e);
        }
    }
}