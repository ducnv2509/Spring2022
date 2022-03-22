package enitity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Users")
public class Users {
    private String id;
    private String password;
    private String fullname;
    private String email;
    private Boolean admin;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    @OneToMany(mappedBy = "user")
    List<Favorites> favorites;
    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "password")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (id != null ? !id.equals(users.id) : users.id != null) return false;
        if (password != null ? !password.equals(users.password) : users.password != null) return false;
        if (fullname != null ? !fullname.equals(users.fullname) : users.fullname != null) return false;
        if (email != null ? !email.equals(users.email) : users.email != null) return false;
        if (admin != null ? !admin.equals(users.admin) : users.admin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (fullname != null ? fullname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (admin != null ? admin.hashCode() : 0);
        return result;
    }
}
