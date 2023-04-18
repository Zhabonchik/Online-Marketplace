package by.fpmibsu.OnlineMarketplace.DAO;

import by.fpmibsu.OnlineMarketplace.entity.Catalog;
import by.fpmibsu.OnlineMarketplace.entity.Catalog;
import by.fpmibsu.OnlineMarketplace.entity.Review;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CatalogDao extends AbstractDaoSimple<Catalog>{
    String SQL_SELECT_ALL = "SELECT * FROM Catalog";
    String SQL_SELECT_BY_CATEGORY = "SELECT * FROM Catalog WHERE Category=?";
    String SQL_SELECT_BY_VENDOR = "SELECT * FROM Catalog WHERE Vendor=?";
    String SQL_SELECT_BY_PRODUCT = "SELECT * FROM Catalog WHERE ID_Product=?";
    String SQL_SELECT_BY_PRICE = "SELECT * FROM Catalog WHERE Price<=?";
    String SQL_SELECT_BY_CATEGORY_AND_PRICE = "SELECT * FROM Catalog WHERE Category=? AND Price<=?";
    String SQL_SELECT_BY_PRODUCT_AND_PRICE = "SELECT * FROM Catalog WHERE Product=? AND Price<=?";
    String SQL_DELETE_BY_ID_PRODUCT = "DELETE FROM Catalog WHERE ID_Product=?";
    String SQL_DELETE_BY_ID_VENDOR = "DELETE FROM Catalog WHERE ID_Vendor=?";
    String SQL_DELETE_BY_CATEGORY = "DELETE FROM Catalog WHERE Category=?";
    String SQL_DELETE_BY_ID_PRODUCT_AND_ID_VENDOR = "DELETE FROM Catalog WHERE ID_Product=? AND ID_Vendor=?";
    @Override
    public List<Catalog> findAll() throws DaoException {
        List<Catalog> Catalogs = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Catalog catalog = new Catalog();
                catalog.setID_vendor_(resultSet.getLong("ID_Vendor"));
                catalog.setID_product_(resultSet.getLong("ID_Product"));
                catalog.setCategory_(resultSet.getString("Category"));
                catalog.setPrice_(resultSet.getFloat("Price"));
                catalog.setNumber_in_stock_(resultSet.getInt("Amount_in_stock"));
                Catalogs.add(catalog);
            }
        } catch (SQLException e){
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
        }
        return Catalogs;
    }
    public List<Catalog> findByCategory(String category) throws DaoException{
        List<Catalog> Catalogs = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_CATEGORY);
            preparedStatement.setString(1,category);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Catalog catalog = new Catalog();
                catalog.setID_vendor_(resultSet.getLong("ID_Vendor"));
                catalog.setID_product_(resultSet.getLong("ID_Product"));
                catalog.setCategory_(resultSet.getString("Category"));
                catalog.setPrice_(resultSet.getFloat("Price"));
                catalog.setNumber_in_stock_(resultSet.getInt("Amount_in_stock"));
                Catalogs.add(catalog);
            }
        } catch (SQLException e){
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
        }
        return Catalogs;
    }
    public List<Catalog> findByVendor(long vendor_id) throws DaoException{
        List<Catalog> Catalogs = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_VENDOR);
            preparedStatement.setLong(1,vendor_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Catalog catalog = new Catalog();
                catalog.setID_vendor_(resultSet.getLong("ID_Vendor"));
                catalog.setID_product_(resultSet.getLong("ID_Product"));
                catalog.setCategory_(resultSet.getString("Category"));
                catalog.setPrice_(resultSet.getFloat("Price"));
                catalog.setNumber_in_stock_(resultSet.getInt("Amount_in_stock"));
                Catalogs.add(catalog);
            }
        } catch (SQLException e){
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
        }
        return Catalogs;
    }
    public List<Catalog> findByProduct(long product_id) throws DaoException{
        List<Catalog> Catalogs = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_PRODUCT);
            preparedStatement.setLong(1,product_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Catalog catalog = new Catalog();
                catalog.setID_vendor_(resultSet.getLong("ID_Vendor"));
                catalog.setID_product_(resultSet.getLong("ID_Product"));
                catalog.setCategory_(resultSet.getString("Category"));
                catalog.setPrice_(resultSet.getFloat("Price"));
                catalog.setNumber_in_stock_(resultSet.getInt("Amount_in_stock"));
                Catalogs.add(catalog);
            }
        } catch (SQLException e){
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
        }
        return Catalogs;
    }
    public List<Catalog> findByPrice(double price) throws DaoException{
        List<Catalog> Catalogs = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_PRICE);
            preparedStatement.setDouble(1,price);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Catalog catalog = new Catalog();
                catalog.setID_vendor_(resultSet.getLong("ID_Vendor"));
                catalog.setID_product_(resultSet.getLong("ID_Product"));
                catalog.setCategory_(resultSet.getString("Category"));
                catalog.setPrice_(resultSet.getFloat("Price"));
                catalog.setNumber_in_stock_(resultSet.getInt("Amount_in_stock"));
                Catalogs.add(catalog);
            }
        } catch (SQLException e){
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
        }
        return Catalogs;
    }
    public List<Catalog> findByCategoryAndPrice(String category, double price) throws DaoException{
        List<Catalog> Catalogs = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_CATEGORY_AND_PRICE);
            preparedStatement.setString(1, category);
            preparedStatement.setDouble(2, price);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Catalog catalog = new Catalog();
                catalog.setID_vendor_(resultSet.getLong("ID_Vendor"));
                catalog.setID_product_(resultSet.getLong("ID_Product"));
                catalog.setCategory_(resultSet.getString("Category"));
                catalog.setPrice_(resultSet.getFloat("Price"));
                catalog.setNumber_in_stock_(resultSet.getInt("Amount_in_stock"));
                Catalogs.add(catalog);
            }
        } catch (SQLException e){
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
        }
        return Catalogs;
    }
    public List<Catalog> findByProductAndPrice(long id_product, double price) throws DaoException{
        List<Catalog> Catalogs = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_PRODUCT_AND_PRICE);
            preparedStatement.setLong(1, id_product);
            preparedStatement.setDouble(2, price);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Catalog catalog = new Catalog();
                catalog.setID_vendor_(resultSet.getLong("ID_Vendor"));
                catalog.setID_product_(resultSet.getLong("ID_Product"));
                catalog.setCategory_(resultSet.getString("Category"));
                catalog.setPrice_(resultSet.getFloat("Price"));
                catalog.setNumber_in_stock_(resultSet.getInt("Amount_in_stock"));
                Catalogs.add(catalog);
            }
        } catch (SQLException e){
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
        }
        return Catalogs;
    }
    public int deleteByVendorId(long id) throws DaoException {
        PreparedStatement preparedStatement = null;
        int result;
        try{
            preparedStatement = connection.prepareStatement(SQL_DELETE_BY_ID_VENDOR);
            preparedStatement.setLong(1, id);
            result = preparedStatement.executeUpdate();
        } catch(SQLException e){
            throw new DaoException(e);
        } finally{
            close(preparedStatement);
        }
        return result;
    }
    public int deleteByProductId(long id) throws DaoException {
        PreparedStatement preparedStatement = null;
        int result;
        try{
            preparedStatement = connection.prepareStatement(SQL_DELETE_BY_ID_PRODUCT);
            preparedStatement.setLong(1, id);
            result = preparedStatement.executeUpdate();
        } catch(SQLException e){
            throw new DaoException(e);
        } finally{
            close(preparedStatement);
        }
        return result;
    }
    public int deleteByCategory(String category) throws DaoException {
        PreparedStatement preparedStatement = null;
        int result;
        try{
            preparedStatement = connection.prepareStatement(SQL_DELETE_BY_CATEGORY);
            preparedStatement.setString(1, category);
            result = preparedStatement.executeUpdate();
        } catch(SQLException e){
            throw new DaoException(e);
        } finally{
            close(preparedStatement);
        }
        return result;
    }

    public int deleteByProductIdAndVendorId(long idP, long idV) throws DaoException {
        PreparedStatement preparedStatement = null;
        int result;
        try{
            preparedStatement = connection.prepareStatement(SQL_DELETE_BY_ID_PRODUCT_AND_ID_VENDOR);
            preparedStatement.setLong(1, idP);
            preparedStatement.setLong(2, idV);
            result = preparedStatement.executeUpdate();
        } catch(SQLException e){
            throw new DaoException(e);
        } finally{
            close(preparedStatement);
        }
        return result;
    }
    public int delete(Catalog entity) throws DaoException {
        return deleteByProductIdAndVendorId(entity.getID_product_(), entity.getID_vendor_());
    }

    public int create(Catalog entity) throws DaoException {
        int result;
        String query = "INSERT INTO Review VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, entity.getID_vendor_());
            preparedStatement.setLong(2, entity.getID_product_());
            preparedStatement.setString(3, entity.getCategory_());
            preparedStatement.setDouble(4,entity.getPrice_());
            preparedStatement.setInt(5, entity.getNumber_in_stock_());
            result = preparedStatement.executeUpdate();
        } catch(SQLException e){
            throw new DaoException(e);
        } finally{
            close(preparedStatement);
        }
        return result;
    }

    public boolean update(Catalog entity) throws DaoException {
        Statement statement = null;
        int result;
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM Catalog WHERE ID_Vendor = %d AND ID_Product = %d", entity.getID_vendor_(), entity.getID_product_()));
            resultSet.updateInt("Amount_in_stock", entity.getNumber_in_stock_());
            resultSet.updateString("Category", entity.getCategory_());
            resultSet.updateDouble("Price", entity.getPrice_());
            resultSet.updateRow();
        } catch(SQLException e){
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        return true;
    }
}
