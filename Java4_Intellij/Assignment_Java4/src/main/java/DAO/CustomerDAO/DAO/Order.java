package DAO.CustomerDAO.DAO;

import entity.Products;

import java.util.Date;

public class Order extends Products {
    private int id, user_id, p_id, orderState, amount;
    private String customerName, ship_address, phone, updated, fixer;
    private Date created;

    public Order() {
    }

    public Order(int id, int user_id, int p_id, int orderState, int amount, String customerName, String ship_address, String phone, Date created, String updated, String fixer) {
        this.id = id;
        this.user_id = user_id;
        this.p_id = p_id;
        this.orderState = orderState;
        this.amount = amount;
        this.customerName = customerName;
        this.ship_address = ship_address;
        this.phone = phone;
        this.created = created;
        this.updated = updated;
        this.fixer = fixer;
    }

    public Order(int user_id, int p_id, int orderState, int amount, String customerName, String ship_address, String phone, Date created, String updated, String fixer) {
        this.user_id = user_id;
        this.p_id = p_id;
        this.orderState = orderState;
        this.amount = amount;
        this.customerName = customerName;
        this.ship_address = ship_address;
        this.phone = phone;
        this.created = created;
        this.updated = updated;
        this.fixer = fixer;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getShip_address() {
        return ship_address;
    }

    public void setShip_address(String ship_address) {
        this.ship_address = ship_address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getFixer() {
        return fixer;
    }

    public void setFixer(String fixer) {
        this.fixer = fixer;
    }
}
