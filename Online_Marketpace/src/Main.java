import java.sql.*;
import by.fpmibsu.OnlineMarketplace.entity.*;
import by.fpmibsu.OnlineMarketplace.DAO.*;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = ConnectionCreator.createConnection();
            PhoneDao phoneDao = new PhoneDao();
            phoneDao.setConnection(connection);
            Phone phone = phoneDao.findById(1);
            System.out.println(phone);
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}