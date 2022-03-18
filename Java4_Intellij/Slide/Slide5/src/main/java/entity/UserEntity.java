package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "User", schema = "dbo", catalog = "Lab05")
public class UserEntity {
    private String userId;
    private String password;
    private String fullname;
    private String email;
    private Boolean admin;

    @Id
    @Column(name = "UserId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "fullname")
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "admin")
    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        UserEntity that = (UserEntity) o;
//
//        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
//        if (password != null ? !password.equals(that.password) : that.password != null) return false;
//        if (fullname != null ? !fullname.equals(that.fullname) : that.fullname != null) return false;
//        if (email != null ? !email.equals(that.email) : that.email != null) return false;
//        if (admin != null ? !admin.equals(that.admin) : that.admin != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = userId != null ? userId.hashCode() : 0;
//        result = 31 * result + (password != null ? password.hashCode() : 0);
//        result = 31 * result + (fullname != null ? fullname.hashCode() : 0);
//        result = 31 * result + (email != null ? email.hashCode() : 0);
//        result = 31 * result + (admin != null ? admin.hashCode() : 0);
//        return result;
//    }
}
