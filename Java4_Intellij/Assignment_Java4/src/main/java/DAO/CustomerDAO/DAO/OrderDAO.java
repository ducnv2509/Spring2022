package DAO.CustomerDAO.DAO;

import entity.Products;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    private Connection con;
    private String query;
    private PreparedStatement pst;
    private ResultSet rs;

    public OrderDAO(Connection con) {
        this.con = con;
    }

    public boolean insertOrder(Order model) {
        boolean result = false;
        try {
            query = "insert into orders (user_id, amount, orderState, created) \n" +
                    "values (? ,?, ?, ?)";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, model.getId());
            pst.setInt(2, model.getAmount());
            pst.setInt(3, model.getOrderState());
            pst.setDate(4, (Date) model.getCreated());
            pst.executeUpdate();
            result = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }


    public List<Order> userOrders(int id) {
        List<Order> list = new ArrayList<>();
        try {
            query = "select * from orders where user_id=? order by orders.id desc";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                ProductDAO productDao = new ProductDAO(this.con);
                int pId = rs.getInt("p_id");
                Products product = productDao.getSingleProduct(pId);
                order.setId(rs.getInt("o_id"));
                order.setId(pId);
                order.setNameProduct(product.getNameProduct());
                order.setSize(product.getSize());
                order.setColor(product.getColor());
                order.setCategoryId(product.getCategoryId());
                order.setPrice(product.getPrice() * rs.getInt("amount"));
                order.setQuantity(rs.getInt("quantity"));
                order.setCreated(rs.getDate("created"));
                list.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void cancelOrder(int id) {
        //boolean result = false;
        try {
            query = "delete from orders where id=?";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, id);
            pst.execute();
            //result = true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
        //return result;
    }
}
