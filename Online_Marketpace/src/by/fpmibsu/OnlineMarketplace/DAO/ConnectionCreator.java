package by.fpmibsu.OnlineMarketplace.DAO;
import java.io.IOException;
import java.sql.*;
import java.util.*;
public class ConnectionCreator {
    private static final String DATABASE_URL = "jdbc:mssql://localhost:1433;";
    private ConnectionCreator(){};
    public static Connection createConnection() throws SQLException{
        String properties = "database=Online_Marketplace;"
                + "user=Nikita;"
                + "password=12345678;"
                + "encrypt=true;"
                + "trustServerCertificate=true;"
                + "loginTimeout=30;";
        return DriverManager.getConnection(DATABASE_URL + properties);
    }
}
