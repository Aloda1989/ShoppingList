package ShoppingList.domain;

import java.math.BigDecimal;
import java.util.List;

public class ProductService {
    public Product pr;

    public ProductService(Product product) {
        this.pr = product;
    }

    public Product createProduct(String name, BigDecimal priceValue, BigDecimal discountValue) {
        Product newProduct = new Product(name, priceValue, discountValue);
        return newProduct;
    }

    public void writeProduct(Product product) {
        pr.insert(product);
    }

    public void setProductDescription(Product product, String productDiscription) {
        pr.setDescription(productDiscription);
    }

    public void setProductCategory(Product product, Category category) {
        product.setCategory(category);
    }

    public Product getProduct(Long productID) {
        return pr.get(productID);
    }

    public Product getProduct(String productName) {
        return pr.get(productName);
    }

    public List<Product> getProductList(Category category) {
        return pr.getProductList(category);
    }

    public Product getProductFromDataBase(Product product) {
        return pr.get(product);
    }

    public void deleteProductFromDataBase(Product product) {
        pr.delete(product);
    }

}
