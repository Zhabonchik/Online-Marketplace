package by.fpmibsu.OnlineMarketplace.DAO;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import by.fpmibsu.OnlineMarketplace.util.PropertiesLoader;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class ConnectionPool {

    private static final String DB_URL = "db.url";
    private static final String USER = "db.user";
    private static final String PASSWORD = "db.password";
    private static final String DRIVER = "db.driver";
    private static final ConnectionPool connectionPool;

    static {
        try {
            connectionPool = getDataSource();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private HikariDataSource dataSource = null;


    public static ConnectionPool getConnectionPool(){return connectionPool;}

    private ConnectionPool(){}
    public static ConnectionPool getDataSource() throws IOException, ClassNotFoundException {
        //FileReader reader=new FileReader("application.properties");

        //Properties p=new Properties();
        //p.load(reader);
        HikariConfig config = new HikariConfig();
        Class.forName(PropertiesLoader.get(DRIVER));
        config.setJdbcUrl(PropertiesLoader.get(DB_URL));
        config.setUsername(PropertiesLoader.get(USER));
        config.setPassword(PropertiesLoader.get(PASSWORD));
        config.addDataSourceProperty("minimumIdle", "5");
        config.addDataSourceProperty("maximumPoolSize", "25");

        HikariDataSource dataSource = new HikariDataSource(config);
        ConnectionPool connectionPool1 = new ConnectionPool();
        connectionPool1.dataSource = dataSource;
        return connectionPool1;
    }

    public Connection getConnection() throws DaoException {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public void close() {
        if (dataSource != null) {
            dataSource.close();
        }
    }
}
