package by.fpmibsu.OnlineMarketplace.service;

import by.fpmibsu.OnlineMarketplace.DAO.ConnectionPool;
import by.fpmibsu.OnlineMarketplace.DAO.ImageDao;
import by.fpmibsu.OnlineMarketplace.DAO.UserDao;
import by.fpmibsu.OnlineMarketplace.DAO.VendorDao;
import by.fpmibsu.OnlineMarketplace.OtherClasses.PasswordHash;
import by.fpmibsu.OnlineMarketplace.entity.Image;
import by.fpmibsu.OnlineMarketplace.entity.User;
import by.fpmibsu.OnlineMarketplace.entity.Vendor;
import by.fpmibsu.OnlineMarketplace.exception.ValidationException;
import by.fpmibsu.OnlineMarketplace.servlet.Servlet;
import by.fpmibsu.OnlineMarketplace.validation.RegisterUserValidator;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import java.sql.Connection;

public class LoginService {
    private static final Logger LOGGER = LogManager.getLogger(LoginService.class);
    private static final LoginService INSTANCE = new LoginService();
    private final UserDao userDao = new UserDao();
    private final VendorDao vendorDao = new VendorDao();

    @SneakyThrows
    public User findUser(String login, String password) throws RuntimeException {
        Connection connection = ConnectionPool.getConnectionPool().getConnection();
        userDao.setConnection(connection);
        User user = userDao.findByLogin(login);
        LOGGER.info("getting user from database");
        if(user.getID_user_() == 0){
            LOGGER.warn("incorrect login or password");
            throw new RuntimeException("Invalid login or password");
        }
        Pbkdf2PasswordEncoder pbkdf2PasswordEncoder = new Pbkdf2PasswordEncoder();
        if(!pbkdf2PasswordEncoder.matches(password, user.getPassword_())){
            LOGGER.warn("incorrect login or password");
            throw new RuntimeException("Invalid login or password");
        }
        connection.close();
        return user;
    }

    @SneakyThrows
    public Vendor findVendor(String login, String password) throws RuntimeException {
        Connection connection = ConnectionPool.getConnectionPool().getConnection();
        vendorDao.setConnection(connection);
        Vendor vendor = vendorDao.findByLogin(login);
        LOGGER.info("getting vendor from database");
        if(vendor.getID_vendor_() == 0){
            LOGGER.warn("incorrect login or password");
            throw new RuntimeException("Invalid login or password");
        }
        Pbkdf2PasswordEncoder pbkdf2PasswordEncoder = new Pbkdf2PasswordEncoder();
        if(!pbkdf2PasswordEncoder.matches(password, vendor.getPassword_())){
            LOGGER.warn("incorrect login or password");
            throw new RuntimeException("Invalid login or password");
        }
        connection.close();
        return vendor;
    }

    public static LoginService getInstance(){
        return INSTANCE;
    }
}
