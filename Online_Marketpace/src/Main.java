import java.awt.*;
import java.net.URI;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.sql.*;
import java.util.*;
import java.util.List;
import java.util.Scanner;

import by.fpmibsu.OnlineMarketplace.entity.*;
import by.fpmibsu.OnlineMarketplace.DAO.*;
import by.fpmibsu.OnlineMarketplace.entity.Image;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

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
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            String password = "Nikita2016";
            random.nextBytes(salt);
            KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = factory.generateSecret(spec).getEncoded();
            System.out.println(hash);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}