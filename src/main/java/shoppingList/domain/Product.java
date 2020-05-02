package shoppingList.domain;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product {
    public Product() {
    }

    // public static Long counter = 0L;
    // public static final Product emptyProduct = new Product("", new BigDecimal(0), new BigDecimal(0));
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "category")
    private Category category;
    @Column(name = "discount")
    private BigDecimal discount;
    @Column(name = "description")
    private String description;
    @Column(name = "user_id")
    private Long userId;

    public Product(String name, BigDecimal priceValue, BigDecimal discountValue) {
        this.name = name;
        price = priceValue;
        discount = discountValue;
//         id = counter.longValue();
//          counter++;
        category = Category.Laptops;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", discount=" + discount +
                ", description='" + description + '\'' +
                ", userId=" + userId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(price, product.price) &&
                category == product.category &&
                Objects.equals(discount, product.discount) &&
                Objects.equals(description, product.description) &&
                Objects.equals(userId, product.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, category, discount, description, userId);
    }
}
