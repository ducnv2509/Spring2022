package DAO;

import entity.Products;

import java.util.ArrayList;

public class OrderDAO {
    public static ArrayList<Products> listProduct = new ArrayList<>();
    public static ArrayList<Products> cart = new ArrayList<>();


    public boolean addCart(int id) {
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getId() == id) {
                cart.add(listProduct.get(i));
                return true;
            }
        }
        return false;
    }

    public boolean deleteCart(int id) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getId() == id) {
                cart.remove(i);
                return true;
            }
        }
        return false;
    }

    public OrderDAO() {
    }

    public static ArrayList<Products> getListProduct() {
        return listProduct;
    }

    public static void setListProduct(ArrayList<Products> listProduct) {
        OrderDAO.listProduct = listProduct;
    }

    public static ArrayList<Products> getCart() {
        return cart;
    }

    public static void setCart(ArrayList<Products> cart) {
        OrderDAO.cart = cart;
    }
}
