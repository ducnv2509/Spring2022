package enitity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Videos")
public class Videos {
    private String id;
    private String title;
    private String poster;
    private String description;
    private Boolean active;
    private Integer views;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    @OneToMany(mappedBy = "video")
    List<Favorites> favorites;

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "poster")
    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "active")
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Basic
    @Column(name = "views")
    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Videos videos = (Videos) o;

        if (id != null ? !id.equals(videos.id) : videos.id != null) return false;
        if (title != null ? !title.equals(videos.title) : videos.title != null) return false;
        if (poster != null ? !poster.equals(videos.poster) : videos.poster != null) return false;
        if (description != null ? !description.equals(videos.description) : videos.description != null) return false;
        if (active != null ? !active.equals(videos.active) : videos.active != null) return false;
        if (views != null ? !views.equals(videos.views) : videos.views != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (poster != null ? poster.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (views != null ? views.hashCode() : 0);
        return result;
    }
}
