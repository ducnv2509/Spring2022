package entity;

import javax.persistence.*;

@Entity
public class Categories {
    private int id;
    private Integer nameCategories;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nameCategories")
    public Integer getNameCategories() {
        return nameCategories;
    }

    public void setNameCategories(Integer nameCategories) {
        this.nameCategories = nameCategories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Categories that = (Categories) o;

        if (id != that.id) return false;
        if (nameCategories != null ? !nameCategories.equals(that.nameCategories) : that.nameCategories != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nameCategories != null ? nameCategories.hashCode() : 0);
        return result;
    }
}
