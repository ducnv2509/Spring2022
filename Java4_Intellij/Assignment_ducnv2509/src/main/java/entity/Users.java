package entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "fullName")
    private String fullName;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "gender")
    private Boolean gender;
    @Basic
    @Column(name = "avatar")
    private String avatar;
    @Basic
    @Column(name = "created")
    private Timestamp created;
    @Basic
    @Column(name = "isAdmin")
    private Boolean isAdmin;
    @Basic
    @Column(name = "status")
    private Boolean status;
    @OneToMany(mappedBy = "usersByUserId")
    private Collection<Favorite> favoritesById;
    @OneToMany(mappedBy = "usersByUserId")
    private Collection<Orders> ordersById;
    @OneToMany(mappedBy = "usersByUserId")
    private Collection<Share> sharesById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (id != users.id) return false;
        if (username != null ? !username.equals(users.username) : users.username != null) return false;
        if (password != null ? !password.equals(users.password) : users.password != null) return false;
        if (fullName != null ? !fullName.equals(users.fullName) : users.fullName != null) return false;
        if (address != null ? !address.equals(users.address) : users.address != null) return false;
        if (email != null ? !email.equals(users.email) : users.email != null) return false;
        if (phone != null ? !phone.equals(users.phone) : users.phone != null) return false;
        if (gender != null ? !gender.equals(users.gender) : users.gender != null) return false;
        if (avatar != null ? !avatar.equals(users.avatar) : users.avatar != null) return false;
        if (created != null ? !created.equals(users.created) : users.created != null) return false;
        if (isAdmin != null ? !isAdmin.equals(users.isAdmin) : users.isAdmin != null) return false;
        if (status != null ? !status.equals(users.status) : users.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (avatar != null ? avatar.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (isAdmin != null ? isAdmin.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    public Collection<Favorite> getFavoritesById() {
        return favoritesById;
    }

    public void setFavoritesById(Collection<Favorite> favoritesById) {
        this.favoritesById = favoritesById;
    }

    public Collection<Orders> getOrdersById() {
        return ordersById;
    }

    public void setOrdersById(Collection<Orders> ordersById) {
        this.ordersById = ordersById;
    }

    public Collection<Share> getSharesById() {
        return sharesById;
    }

    public void setSharesById(Collection<Share> sharesById) {
        this.sharesById = sharesById;
    }
}
