package by.fpmibsu.OnlineMarketplace.DAO;

import by.fpmibsu.OnlineMarketplace.entity.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao extends AbstractDaoSimple<Order>{
    String SQL_SELECT_ALL = "SELECT * FROM Order";
    String SQL_SELECT_BY_ID_ORDER = "SELECT * FROM Order WHERE ID_Order=?";
    String SQL_SELECT_BY_ID_USER = "SELECT * FROM Order WHERE ID_User=?";
    String SQL_SELECT_BY_ID_PRODUCT = "SELECT * FROM Order WHERE ID_Product=?";
    String SQL_SELECT_BY_ID_VENDOR = "SELECT * FROM Order WHERE ID_Vendor=?";
    String SQL_SELECT_BY_DELIVERY_DATE = "SELECT * FROM Order WHERE Delivery_date<=?";
    String SQL_SELECT_BY_ID_USER_AND_ID_PRODUCT = "SELECT * FROM Order WHERE ID_User=? AND ID_Product=?";
    String SQL_SELECT_BY_ID_USER_AND_DELIVERY_DATE = "SELECT * FROM Order WHERE ID_User=? AND Delivery_date<=?";

    String SQL_DELETE_BY_ID_USER_AND_ID_PRODUCT_AND_ID_DATE = "DELETE FROM Order WHERE ID_User=? AND ID_Product=? AND ID_Vendor=?";
    String SQL_DELETE_BY_ID_ORDER = "DELETE FROM Order WHERE ID_Order=?";

    public OrderDao(){
        this.connection = null;
    }

    @Override
    public List<Order> findAll() throws DaoException {
        List<Order> orders = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Order order = new Order();
                order.setID_order(resultSet.getLong("ID_Order"));
                order.setID_user_(resultSet.getLong("ID_User"));
                order.setID_product_(resultSet.getLong("ID_Product"));
                order.setID_vendor_(resultSet.getLong("ID_Vendor"));
                order.setAmount(resultSet.getInt("Amount"));
                order.setPayment_method_(resultSet.getString("Payment_method"));
                order.setDelivery_date_(resultSet.getDate("Delivery_date"));
                order.setDelivery_method_(resultSet.getString("Delivery_method"));
                order.setComments_(resultSet.getString("Comments"));
                orders.add(order);
            }
        } catch(SQLException e){
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
        }
        return orders;
    }
    public Order findBYIdOrder(long idOrder) throws DaoException {
        Order order = new Order();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID_ORDER);
            preparedStatement.setLong(1, idOrder);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                order.setID_order(resultSet.getLong("ID_Order"));
                order.setID_user_(resultSet.getLong("ID_User"));
                order.setID_product_(resultSet.getLong("ID_Product"));
                order.setID_vendor_(resultSet.getLong("ID_Vendor"));
                order.setAmount(resultSet.getInt("Amount"));
                order.setPayment_method_(resultSet.getString("Payment_method"));
                order.setDelivery_date_(resultSet.getDate("Delivery_date"));
                order.setDelivery_method_(resultSet.getString("Delivery_method"));
                order.setComments_(resultSet.getString("Comments"));
            }
        } catch(SQLException e){
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
        }
        return order;
    }
    public List<Order> findByIdUser(long idUser) throws DaoException {
        List<Order> orders = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID_USER);
            preparedStatement.setLong(1, idUser);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Order order = new Order();
                order.setID_order(resultSet.getLong("ID_Order"));
                order.setID_user_(resultSet.getLong("ID_User"));
                order.setID_product_(resultSet.getLong("ID_Product"));
                order.setID_vendor_(resultSet.getLong("ID_Vendor"));
                order.setAmount(resultSet.getInt("Amount"));
                order.setPayment_method_(resultSet.getString("Payment_method"));
                order.setDelivery_date_(resultSet.getDate("Delivery_date"));
                order.setDelivery_method_(resultSet.getString("Delivery_method"));
                order.setComments_(resultSet.getString("Comments"));
                orders.add(order);
            }
        } catch(SQLException e){
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
        }
        return orders;
    }
    public List<Order> findByIdProduct(long idProduct) throws DaoException {
        List<Order> orders = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID_PRODUCT);
            preparedStatement.setLong(1, idProduct);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Order order = new Order();
                order.setID_order(resultSet.getLong("ID_Order"));
                order.setID_user_(resultSet.getLong("ID_User"));
                order.setID_product_(resultSet.getLong("ID_Product"));
                order.setID_vendor_(resultSet.getLong("ID_Vendor"));
                order.setAmount(resultSet.getInt("Amount"));
                order.setPayment_method_(resultSet.getString("Payment_method"));
                order.setDelivery_date_(resultSet.getDate("Delivery_date"));
                order.setDelivery_method_(resultSet.getString("Delivery_method"));
                order.setComments_(resultSet.getString("Comments"));
                orders.add(order);
            }
        } catch(SQLException e){
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
        }
        return orders;
    }
    public List<Order> findByIdVendor(long idVendor) throws DaoException {
        List<Order> orders = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID_VENDOR);
            preparedStatement.setLong(1, idVendor);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Order order = new Order();
                order.setID_order(resultSet.getLong("ID_Order"));
                order.setID_user_(resultSet.getLong("ID_User"));
                order.setID_product_(resultSet.getLong("ID_Product"));
                order.setID_vendor_(resultSet.getLong("ID_Vendor"));
                order.setAmount(resultSet.getInt("Amount"));
                order.setPayment_method_(resultSet.getString("Payment_method"));
                order.setDelivery_date_(resultSet.getDate("Delivery_date"));
                order.setDelivery_method_(resultSet.getString("Delivery_method"));
                order.setComments_(resultSet.getString("Comments"));
                orders.add(order);
            }
        } catch(SQLException e){
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
        }
        return orders;
    }
    public List<Order> findByDeliveryDate(Date date) throws DaoException {
        List<Order> orders = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_DELIVERY_DATE);
            preparedStatement.setDate(1, date);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Order order = new Order();
                order.setID_order(resultSet.getLong("ID_Order"));
                order.setID_user_(resultSet.getLong("ID_User"));
                order.setID_product_(resultSet.getLong("ID_Product"));
                order.setID_vendor_(resultSet.getLong("ID_Vendor"));
                order.setAmount(resultSet.getInt("Amount"));
                order.setPayment_method_(resultSet.getString("Payment_method"));
                order.setDelivery_date_(resultSet.getDate("Delivery_date"));
                order.setDelivery_method_(resultSet.getString("Delivery_method"));
                order.setComments_(resultSet.getString("Comments"));
                orders.add(order);
            }
        } catch(SQLException e){
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
        }
        return orders;
    }
    public List<Order> findByIdUserAndDeliveryDate(long idUser, Date date) throws DaoException {
        List<Order> orders = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID_USER_AND_DELIVERY_DATE);
            preparedStatement.setLong(1, idUser);
            preparedStatement.setDate(2, date);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Order order = new Order();
                order.setID_order(resultSet.getLong("ID_Order"));
                order.setID_user_(resultSet.getLong("ID_User"));
                order.setID_product_(resultSet.getLong("ID_Product"));
                order.setID_vendor_(resultSet.getLong("ID_Vendor"));
                order.setAmount(resultSet.getInt("Amount"));
                order.setPayment_method_(resultSet.getString("Payment_method"));
                order.setDelivery_date_(resultSet.getDate("Delivery_date"));
                order.setDelivery_method_(resultSet.getString("Delivery_method"));
                order.setComments_(resultSet.getString("Comments"));
                orders.add(order);
            }
        } catch(SQLException e){
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
        }
        return orders;
    }
    public List<Order> findByIdUserAndIdProduct(long idUser, long idProduct) throws DaoException {
        List<Order> orders = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID_USER_AND_ID_PRODUCT);
            preparedStatement.setLong(1, idUser);
            preparedStatement.setLong(2, idProduct);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Order order = new Order();
                order.setID_order(resultSet.getLong("ID_Order"));
                order.setID_user_(resultSet.getLong("ID_User"));
                order.setID_product_(resultSet.getLong("ID_Product"));
                order.setID_vendor_(resultSet.getLong("ID_Vendor"));
                order.setAmount(resultSet.getInt("Amount"));
                order.setPayment_method_(resultSet.getString("Payment_method"));
                order.setDelivery_date_(resultSet.getDate("Delivery_date"));
                order.setDelivery_method_(resultSet.getString("Delivery_method"));
                order.setComments_(resultSet.getString("Comments"));
                orders.add(order);
            }
        } catch(SQLException e){
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
        }
        return orders;
    }
    public int deleteByIdOrder(long id) throws DaoException {
        PreparedStatement preparedStatement = null;
        int result;
        try{
            preparedStatement = connection.prepareStatement(SQL_DELETE_BY_ID_ORDER);
            preparedStatement.setLong(1, id);
            result = preparedStatement.executeUpdate();
        } catch(SQLException e){
            throw new DaoException(e);
        } finally{
            close(preparedStatement);
        }
        return result;
    }
    public int deleteByUserProductDate(long idU, long idP, Date date) throws DaoException {
        PreparedStatement preparedStatement = null;
        int result;
        try{
            preparedStatement = connection.prepareStatement(SQL_DELETE_BY_ID_USER_AND_ID_PRODUCT_AND_ID_DATE);
            preparedStatement.setLong(1, idU);
            preparedStatement.setLong(2, idP);
            preparedStatement.setDate(3, date);
            result = preparedStatement.executeUpdate();
        } catch(SQLException e){
            throw new DaoException(e);
        } finally{
            close(preparedStatement);
        }
        return result;
    }
    public int create(Order entity) throws DaoException {
        int result = 0;
        String query = "INSERT INTO Review VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, entity.getID_user_());
            preparedStatement.setLong(2, entity.getID_product_());
            preparedStatement.setLong(3, entity.getID_vendor_());
            preparedStatement.setInt(4, entity.getAmount());
            preparedStatement.setString(5, entity.getPayment_method_());
            preparedStatement.setDate(6, entity.getDelivery_date_());
            preparedStatement.setString(7, entity.getDelivery_method_());
            preparedStatement.setString(8, entity.getComments_());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if(rs != null && rs.next()){
                result = rs.getInt(1);
            }
        } catch(SQLException e){
            throw new DaoException(e);
        } finally{
            close(preparedStatement);
        }
        return result;
    }
    public boolean update(Order entity) throws DaoException {
        Statement statement = null;
        int result;
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM Order WHERE ID_Order = %d", entity.getID_order()));
            resultSet.updateLong("ID_User", entity.getID_user_());
            resultSet.updateLong("ID_Product", entity.getID_product_());
            resultSet.updateLong("ID_Vendor", entity.getID_vendor_());
            resultSet.updateInt("Amount", entity.getAmount());
            resultSet.updateString("Payment_method", entity.getPayment_method_());
            resultSet.updateDate("Delivery_date", entity.getDelivery_date_());
            resultSet.updateString("Delivery_method", entity.getDelivery_method_());
            resultSet.updateString("Comments", entity.getComments_());
            resultSet.updateRow();
        } catch(SQLException e){
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        return true;
    }
}
