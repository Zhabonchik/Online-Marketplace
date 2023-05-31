import java.sql.*;
import java.util.*;


import by.fpmibsu.OnlineMarketplace.DAO.ConnectionPool;
import by.fpmibsu.OnlineMarketplace.DAO.ReviewDao;
import by.fpmibsu.OnlineMarketplace.OtherClasses.PasswordHash;
import by.fpmibsu.OnlineMarketplace.entity.Review;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Connection connection = ConnectionPool.getConnectionPool().getConnection();
            ReviewDao reviewDao = new ReviewDao();
            reviewDao.setConnection(connection);
            Review review = new Review();
            review.setID_user_(7);
            review.setID_product_(1);
            review.setReview_("Very good, but expensive");
            reviewDao.create(review);
            /*System.out.println(reviewDao.findByProductId(1));
            System.out.println(reviewDao.findByUserId(1));
            System.out.println(reviewDao.findByUserIdAndProductId(1,1));*/
            ConnectionPool.getConnectionPool().close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        /*try {
            Pbkdf2PasswordEncoder pbkdf2PasswordEncoder = new Pbkdf2PasswordEncoder();
            String pbkdf2CryptedPassword = pbkdf2PasswordEncoder.encode("123");
            if(pbkdf2PasswordEncoder.matches("123", pbkdf2CryptedPassword)){
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

        } catch(Exception e){

        }*/
    }
}