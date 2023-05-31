package by.fpmibsu.OnlineMarketplace.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class AbstractDaoSimple <T> {
    protected Connection connection = null;
    public void setConnection(Connection connection){
        this.connection = connection;
    }
    public abstract List<T> findAll() throws DaoException;

    public void close(Statement statement){
        try{
            if(statement != null){
                statement.close();
            }
        } catch(SQLException e){

        }
    }
}

