package entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Supplier {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nameSupplier")
    private String nameSupplier;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "address")
    private String address;
    @OneToMany(mappedBy = "supplierBySupplierId")
    private Collection<Products> productsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSupplier() {
        return nameSupplier;
    }

    public void setNameSupplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

        Supplier supplier = (Supplier) o;

        if (id != supplier.id) return false;
        if (nameSupplier != null ? !nameSupplier.equals(supplier.nameSupplier) : supplier.nameSupplier != null)
            return false;
        if (phone != null ? !phone.equals(supplier.phone) : supplier.phone != null) return false;
        if (address != null ? !address.equals(supplier.address) : supplier.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nameSupplier != null ? nameSupplier.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    public Collection<Products> getProductsById() {
        return productsById;
    }

    public void setProductsById(Collection<Products> productsById) {
        this.productsById = productsById;
    }
}
