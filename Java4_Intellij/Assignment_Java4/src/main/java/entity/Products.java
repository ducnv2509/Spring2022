package entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Products {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "nameProduct", nullable = true, length = 255)
    private String nameProduct;
    @Basic
    @Column(name = "category_id", nullable = true)
    private Integer categoryId;
    @Basic
    @Column(name = "supplier_id", nullable = true)
    private Integer supplierId;
    @Basic
    @Column(name = "quantity", nullable = true)
    private Integer quantity;
    @Basic
    @Column(name = "price", nullable = true)
    private Integer price;
    @Basic
    @Column(name = "color", nullable = true, length = 255)
    private String color;
    @Basic
    @Column(name = "size", nullable = true, length = 255)
    private String size;
    @Basic
    @Column(name = "imageProduct", nullable = true, length = 2147483647)
    private String imageProduct;
    @Basic
    @Column(name = "description", nullable = true, length = 2147483647)
    private String description;
    @Basic
    @Column(name = "title", nullable = true, length = 2147483647)
    private String title;
    @Basic
    @Column(name = "lastUpdate", nullable = true)
    private Date lastUpdate;
    @Basic
    @Column(name = "created", nullable = true)
    private Date created;
    @OneToMany(mappedBy = "productsByProductId")
    private Collection<Favorite> favoritesById;
    @OneToMany(mappedBy = "productsByProductId")
    private Collection<Orderdetails> orderdetailsById;
    @ManyToOne(optional = false)

    @JoinColumn(name = "category_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Category categoryByCategoryId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "supplier_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Supplier supplierBySupplierId;

    public Products() {

    }

    public Products(int id, String nameProduct, Integer categoryId, Integer supplierId, Integer quantity, Integer price, String color, String size, String imageProduct, String description, String title, Date lastUpdate, Date created) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.categoryId = categoryId;
        this.supplierId = supplierId;
        this.quantity = quantity;
        this.price = price;
        this.color = color;
        this.size = size;
        this.imageProduct = imageProduct;
        this.description = description;
        this.title = title;
        this.lastUpdate = lastUpdate;
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getImageProduct() {
        return imageProduct;
    }

    public void setImageProduct(String imageProduct) {
        this.imageProduct = imageProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Products products = (Products) o;

        if (id != products.id) return false;
        if (nameProduct != null ? !nameProduct.equals(products.nameProduct) : products.nameProduct != null)
            return false;
        if (categoryId != null ? !categoryId.equals(products.categoryId) : products.categoryId != null) return false;
        if (supplierId != null ? !supplierId.equals(products.supplierId) : products.supplierId != null) return false;
        if (quantity != null ? !quantity.equals(products.quantity) : products.quantity != null) return false;
        if (price != null ? !price.equals(products.price) : products.price != null) return false;
        if (color != null ? !color.equals(products.color) : products.color != null) return false;
        if (size != null ? !size.equals(products.size) : products.size != null) return false;
        if (imageProduct != null ? !imageProduct.equals(products.imageProduct) : products.imageProduct != null)
            return false;
        if (description != null ? !description.equals(products.description) : products.description != null)
            return false;
        if (title != null ? !title.equals(products.title) : products.title != null) return false;
        if (lastUpdate != null ? !lastUpdate.equals(products.lastUpdate) : products.lastUpdate != null) return false;
        if (created != null ? !created.equals(products.created) : products.created != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nameProduct != null ? nameProduct.hashCode() : 0);
        result = 31 * result + (categoryId != null ? categoryId.hashCode() : 0);
        result = 31 * result + (supplierId != null ? supplierId.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (imageProduct != null ? imageProduct.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        return result;
    }

    public Collection<Favorite> getFavoritesById() {
        return favoritesById;
    }

    public void setFavoritesById(Collection<Favorite> favoritesById) {
        this.favoritesById = favoritesById;
    }

    public Collection<Orderdetails> getOrderdetailsById() {
        return orderdetailsById;
    }

    public void setOrderdetailsById(Collection<Orderdetails> orderdetailsById) {
        this.orderdetailsById = orderdetailsById;
    }

    public Category getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(Category categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }

    public Supplier getSupplierBySupplierId() {
        return supplierBySupplierId;
    }

    public void setSupplierBySupplierId(Supplier supplierBySupplierId) {
        this.supplierBySupplierId = supplierBySupplierId;
    }
}
