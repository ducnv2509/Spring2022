package entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Share {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "user_id")
    private Integer userId;
    @Basic
    @Column(name = "product_id")
    private Integer productId;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "shareDate")
    private Timestamp shareDate;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Products productsByProductId;

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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getShareDate() {
        return shareDate;
    }

    public void setShareDate(Timestamp shareDate) {
        this.shareDate = shareDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Share share = (Share) o;

        if (id != share.id) return false;
        if (userId != null ? !userId.equals(share.userId) : share.userId != null) return false;
        if (productId != null ? !productId.equals(share.productId) : share.productId != null) return false;
        if (email != null ? !email.equals(share.email) : share.email != null) return false;
        if (shareDate != null ? !shareDate.equals(share.shareDate) : share.shareDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (shareDate != null ? shareDate.hashCode() : 0);
        return result;
    }

    public Products getProductsByProductId() {
        return productsByProductId;
    }

    public void setProductsByProductId(Products productsByProductId) {
        this.productsByProductId = productsByProductId;
    }
}
