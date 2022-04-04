package DAO;

import entity.Products;

public class Item {
    Products products;
    int amountQuantity;

    public Item() {
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public int getAmountQuantity() {
        return amountQuantity;
    }

    public void setAmountQuantity(int amountQuantity) {
        this.amountQuantity = amountQuantity;
    }

}
