package entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Orders {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "user_id")
    private Integer userId;
    @Basic
    @Column(name = "amount")
    private Double amount;
    @Basic
    @Column(name = "orderState")
    private Integer orderState;
    @Basic
    @Column(name = "customerName")
    private String customerName;
    @Basic
    @Column(name = "ship_address")
    private String shipAddress;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "created")
    private Date created;
    @Basic
    @Column(name = "updated")
    private Date updated;
    @Basic
    @Column(name = "fixer")
    private Date fixer;
    @OneToMany(mappedBy = "ordersByOrderId")
    private Collection<Orderdetails> orderdetailsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Date getFixer() {
        return fixer;
    }

    public void setFixer(Date fixer) {
        this.fixer = fixer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (id != orders.id) return false;
        if (userId != null ? !userId.equals(orders.userId) : orders.userId != null) return false;
        if (amount != null ? !amount.equals(orders.amount) : orders.amount != null) return false;
        if (orderState != null ? !orderState.equals(orders.orderState) : orders.orderState != null) return false;
        if (customerName != null ? !customerName.equals(orders.customerName) : orders.customerName != null)
            return false;
        if (shipAddress != null ? !shipAddress.equals(orders.shipAddress) : orders.shipAddress != null) return false;
        if (phone != null ? !phone.equals(orders.phone) : orders.phone != null) return false;
        if (created != null ? !created.equals(orders.created) : orders.created != null) return false;
        if (updated != null ? !updated.equals(orders.updated) : orders.updated != null) return false;
        if (fixer != null ? !fixer.equals(orders.fixer) : orders.fixer != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (orderState != null ? orderState.hashCode() : 0);
        result = 31 * result + (customerName != null ? customerName.hashCode() : 0);
        result = 31 * result + (shipAddress != null ? shipAddress.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (updated != null ? updated.hashCode() : 0);
        result = 31 * result + (fixer != null ? fixer.hashCode() : 0);
        return result;
    }

    public Collection<Orderdetails> getOrderdetailsById() {
        return orderdetailsById;
    }

    public void setOrderdetailsById(Collection<Orderdetails> orderdetailsById) {
        this.orderdetailsById = orderdetailsById;
    }
}
