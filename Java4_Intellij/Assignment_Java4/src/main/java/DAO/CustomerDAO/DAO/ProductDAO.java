package DAO.CustomerDAO.DAO;

import entity.Products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private Connection con;
    private String query;
    private PreparedStatement pst;
    private ResultSet rs;

    public ProductDAO(Connection con) {
        this.con = con;
    }

    public List<Products> getAllProducts() {
        List<Products> book = new ArrayList<>();
        try {

            query = "select * from products";
            pst = this.con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                book.add(new Products(
                        rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
                        rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getString(11), rs.getDate(12), rs.getDate(13)
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return book;
    }

    public double getTotalCartPrice(ArrayList<Cart> cartList) {
        double sum = 0;
        try {
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                    query = "select price from products where id=?";
                    pst = this.con.prepareStatement(query);
                    pst.setInt(1, item.getId());
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        sum += rs.getDouble("price") * item.getQuantity();
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return sum;
    }


    public Products getSingleProduct(int id) {
        Products row = null;
        try {
            query = "select * from products where id=? ";

            pst = this.con.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                row = new Products();
                row.setId(rs.getInt("id"));
                row.setNameProduct(rs.getString("nameProduct"));
                row.setCategoryId(rs.getInt("category_id"));
                row.setPrice((rs.getInt("price")));
                row.setImageProduct(rs.getString("imageProduct"));
                row.setSupplierId(rs.getInt("supplier_id"));
                row.setQuantity(rs.getInt("quantity"));
                row.setColor(rs.getString("color"));
                row.setSize(rs.getString("size"));
                row.setDescription(rs.getString("description"));
                row.setTitle(rs.getString("title"));
                row.setLastUpdate(rs.getDate("lastUpdate"));
                row.setCreated(rs.getDate("created"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return row;
    }

    public List<Cart> getCartProducts(ArrayList<Cart> cartList) {
        List<Cart> book = new ArrayList<>();
        try {
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                    query = "select * from products where id=?";
                    pst = this.con.prepareStatement(query);
                    pst.setInt(1, item.getId());
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        Cart row = new Cart();
                        row.setId(rs.getInt("id"));
                        row.setNameProduct(rs.getString("nameProduct"));
                        row.setColor(rs.getString("color"));
                        row.setSize(rs.getString("size"));
                        row.setCategoryId(rs.getInt("category_id"));
                        row.setPrice(rs.getInt("price") * item.getQuantity());
                        row.setQuantity(item.getQuantity());
                        book.add(row);
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return book;
    }
}
