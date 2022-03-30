package entity;

import javax.persistence.*;

@Entity
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "fullName", nullable = true, length = 255)
    private String fullName;
    @Basic
    @Column(name = "address", nullable = true, length = 255)
    private String address;
    @Basic
    @Column(name = "email", nullable = true, length = 255)
    private String email;
    @Basic
    @Column(name = "password", nullable = true, length = 255)
    private String password;
    @Basic
    @Column(name = "avatar", nullable = true, length = 255)
    private String avatar;
    @Basic
    @Column(name = "phone", nullable = true, length = 15)
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (id != users.id) return false;
        if (fullName != null ? !fullName.equals(users.fullName) : users.fullName != null) return false;
        if (address != null ? !address.equals(users.address) : users.address != null) return false;
        if (email != null ? !email.equals(users.email) : users.email != null) return false;
        if (password != null ? !password.equals(users.password) : users.password != null) return false;
        if (avatar != null ? !avatar.equals(users.avatar) : users.avatar != null) return false;
        if (phone != null ? !phone.equals(users.phone) : users.phone != null) return false;

        return true;
    }

    public Users() {
    }

    public Users(int id, String fullName, String address, String email, String password, String avatar, String phone) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (avatar != null ? avatar.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }
}
