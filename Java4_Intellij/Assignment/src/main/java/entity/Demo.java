package entity;

import javax.persistence.*;

@Entity
public class Demo {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "nameM")
    private String nameM;

    public String getNameM() {
        return nameM;
    }

    public void setNameM(String nameM) {
        this.nameM = nameM;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Demo demo = (Demo) o;

        if (nameM != null ? !nameM.equals(demo.nameM) : demo.nameM != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return nameM != null ? nameM.hashCode() : 0;
    }
}
