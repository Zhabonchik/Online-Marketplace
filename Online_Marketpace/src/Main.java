import java.sql.*;
import java.util.*;

import by.fpmibsu.OnlineMarketplace.entity.*;
import by.fpmibsu.OnlineMarketplace.DAO.*;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = ConnectionCreator.createConnection();
            PhoneDao phoneDao = new PhoneDao();
            phoneDao.setConnection(connection);
            List<Phone> phones = phoneDao.findByManufacturer("Apple inc.");
            for(Phone el : phones){
                System.out.println(el);
            }
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}