package by.fpmibsu.OnlineMarketplace.service;

import by.fpmibsu.OnlineMarketplace.DAO.ConnectionPool;
import by.fpmibsu.OnlineMarketplace.DAO.ImageDao;
import by.fpmibsu.OnlineMarketplace.DAO.PhoneDao;
import by.fpmibsu.OnlineMarketplace.entity.Image;
import by.fpmibsu.OnlineMarketplace.entity.Phone;
import by.fpmibsu.OnlineMarketplace.entity.User;
import by.fpmibsu.OnlineMarketplace.exception.ValidationException;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.util.List;

public class PhoneService {
    private static final Logger LOGGER = LogManager.getLogger(PhoneService.class);
    private static final PhoneService INSTANCE = new PhoneService();
    private final PhoneDao phoneDao = new PhoneDao();
    @SneakyThrows
    public List<Phone> getAllPhones(){
        LOGGER.info("getting connection in getAllPhones");
        Connection connection = ConnectionPool.getConnectionPool().getConnection();
        LOGGER.info("setting connection in getAllPhones");
        phoneDao.setConnection(connection);
        LOGGER.info("getting phones in getAllPhones");
        List<Phone> phones = phoneDao.findAll();
        LOGGER.info("closing connection in getAllPhones");
        connection.close();
        return phones;
    }

    @SneakyThrows
    public String imageRef(Long id){
        LOGGER.info("getting connection in imageRef");
        Connection connection = ConnectionPool.getConnectionPool().getConnection();
        ImageDao imageDao = new ImageDao();
        LOGGER.info("setting connection in imageRef");
        imageDao.setConnection(connection);
        LOGGER.info("getting link in imageRef");
        String link = imageDao.findById(id).getLink_();
        LOGGER.info("closing connection in imageRef");
        connection.close();
        return link;
    }

    @SneakyThrows
    public Phone getPhoneById(Long id){
        LOGGER.info("getting connection in getPhoneById");
        Connection connection = ConnectionPool.getConnectionPool().getConnection();
        LOGGER.info("setting connection in getPhoneById");
        phoneDao.setConnection(connection);
        LOGGER.info("getting phone in getPhoneById");
        Phone phone = phoneDao.findById(id);
        LOGGER.info("closing connection in getPhoneById");
        connection.close();
        return phone;
    }

    public static PhoneService getInstance(){
        return INSTANCE;
    }
}
