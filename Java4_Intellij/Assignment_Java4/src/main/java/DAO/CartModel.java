package DAO;

import entity.Products;

import java.util.HashMap;

public class CartModel {
    HashMap<Integer, Item> cart;

    public CartModel() {
        cart = new HashMap<>();
    }

    public void addProductCart(int id){
        if(cart.containsKey(id)){

        }else{
//            Products products = new CartModel().get

        }
    }


}
