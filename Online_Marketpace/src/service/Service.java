package service;

import by.fpmibsu.OnlineMarketplace.DAO.DaoException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.sql.Connection;

public abstract class Service <T> {
    protected Connection connection;
    public void setConnection(Connection connection){
        this.connection = connection;
    }
    public abstract JSONArray findAll() throws DaoException;
    public abstract JSONArray findById(HttpServletRequest request) throws DaoException;
    //public abstract JSONObject deleteEntity(HttpServletRequest request) throws DaoException;
    public abstract JSONArray deleteById(HttpServletRequest request) throws DaoException;
    public abstract JSONArray create(HttpServletRequest request) throws DaoException;
    public abstract JSONArray update(HttpServletRequest request) throws DaoException;

}
