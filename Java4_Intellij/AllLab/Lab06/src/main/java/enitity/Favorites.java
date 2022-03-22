package enitity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Favorites", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"videoid", "userid"})
})
public class Favorites {
    private long id;
    private Date likedate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "userid")
    Users user;
    @ManyToOne
    @JoinColumn(name = "videoid")
    Videos video;

    @Temporal(TemporalType.DATE)
    @Basic
    @Column(name = "likedate")
    public Date getLikedate() {
        return likedate;
    }

    public void setLikedate(Date likedate) {
        this.likedate = likedate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Favorites favorites = (Favorites) o;

        if (id != favorites.id) return false;
        if (likedate != null ? !likedate.equals(favorites.likedate) : favorites.likedate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (likedate != null ? likedate.hashCode() : 0);
        return result;
    }
}
