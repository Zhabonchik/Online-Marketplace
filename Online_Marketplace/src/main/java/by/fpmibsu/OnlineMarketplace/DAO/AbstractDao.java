package by.fpmibsu.OnlineMarketplace.DAO;
import java.sql.*;
import java.util.*;

public abstract class AbstractDao <T> {
    protected Connection connection = null;
    public void setConnection(Connection connection){
        this.connection = connection;
    }
    public abstract List<T> findAll() throws DaoException;
    public abstract T findById(long id) throws DaoException;
    public abstract int delete(long id) throws DaoException;
    public abstract int delete(T entity) throws DaoException;
    public abstract int create(T entity) throws DaoException;
    public abstract boolean update(T entity) throws DaoException;
    public void close(Statement statement){
        try{
            if(statement != null){
                statement.close();
            }
        } catch(SQLException e){

        }
    }
}
