import java.awt.*;
import java.sql.*;
import java.util.*;
import java.util.List;

import by.fpmibsu.OnlineMarketplace.entity.*;
import by.fpmibsu.OnlineMarketplace.DAO.*;
import org.json.simple.JSONObject;

public class Main {
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        try {
            Connection connection = ConnectionCreator.createConnection();
            PhoneDao phoneDao = new PhoneDao();
            phoneDao.setConnection(connection);
            List<Phone> phones = phoneDao.findByManufacturer("Apple inc.");
            for(Phone el : phones){
                System.out.println(el);
            }
            ReviewDao reviewDao = new ReviewDao();
            reviewDao.setConnection(connection);
            Review review = new Review();
            review.setID_user_(1);
            review.setID_product_(1);
            review.setReview_("Very good, but expensive");
            //reviewDao.create(review);
            System.out.println(reviewDao.findByProductId(1));
            System.out.println(reviewDao.findByUserId(1));
            System.out.println(reviewDao.findByUserIdAndProductId(1,1));
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }*/
    }
}