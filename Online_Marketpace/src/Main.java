import java.awt.*;
import java.net.URI;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.sql.*;
import java.util.*;
import java.util.List;
import java.util.Scanner;

import by.fpmibsu.OnlineMarketplace.OtherClasses.PasswordHash;
import by.fpmibsu.OnlineMarketplace.entity.*;
import by.fpmibsu.OnlineMarketplace.DAO.*;
import by.fpmibsu.OnlineMarketplace.entity.Image;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.lang.model.type.NullType;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Connection connection = ConnectionCreator.createConnection();
            PhoneDao phoneDao = new PhoneDao();
            phoneDao.setConnection(connection);
            List<Phone> phones = phoneDao.findByManufacturer("Apple inc.");
            for(Phone el : phones){
                System.out.println(el);
            }
            User user = new User(1, Role.Customer,"King","12345678","Roman", "Reigns", "no", 11);
            UserDao userDao = new UserDao();
            userDao.setConnection(connection);
            System.out.println(PasswordHash.getHash(user.getPassword_()));
            //userDao.create(user);
            User user2 = userDao.findByLogin("King");
            if(user2.getPassword_().equals(PasswordHash.getHash("12345678"))){
                System.out.println("Equals");
            }
            if(!user2.getPassword_().equals(PasswordHash.getHash("12345679"))){
                System.out.println("Doesn't equal");
            }
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}