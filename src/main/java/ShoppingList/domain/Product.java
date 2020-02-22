package ShoppingList.domain;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Objects;

@Repository
public class Product {
    public static Long counter = 0L;
    public static final Product emptyProduct = new Product("", new BigDecimal(0), new BigDecimal(0));

    private Long id;
    private String name;
    private BigDecimal price;
    private Category category;
    private BigDecimal discount;
    private String description;

    public Product(String name, BigDecimal priceValue, BigDecimal discountValue) {
        this.name = name;
        price = priceValue;
        discount = discountValue;
        id = counter;
        counter++;
        category = Category.Laptops;

    }

    public Product() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) &&
                Objects.equals(id, product.id) &&
                category == product.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, category);
    }

    @Override
    public String toString() {
        return "Product{" +
                "Id=" + id +
                ", Name='" + name + '\'' +
                ", Price=" + price +
                ", Category=" + category +
                ", Discount=" + discount +
                ", Description='" + description + '\'' +
                '}';
    }
}
