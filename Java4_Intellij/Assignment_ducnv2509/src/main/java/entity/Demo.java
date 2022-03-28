package entity;

import javax.persistence.*;

@Entity
public class Demo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "nameM")
    private String nameM;
    @Basic
    @Column(name = "address")
    private String address;

    public String getNameM() {
        return nameM;
    }

    public void setNameM(String nameM) {
        this.nameM = nameM;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Demo demo = (Demo) o;

        if (nameM != null ? !nameM.equals(demo.nameM) : demo.nameM != null) return false;
        if (address != null ? !address.equals(demo.address) : demo.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nameM != null ? nameM.hashCode() : 0;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
