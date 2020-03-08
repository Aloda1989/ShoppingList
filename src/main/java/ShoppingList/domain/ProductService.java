package ShoppingList.domain;

import ShoppingList.repository.ProductInMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;


@Component
public class ProductService {
    private ProductInMemory pim;

    @Autowired
    public ProductService(ProductInMemory pim) {
        this.pim = pim;
    }

    public Product createProduct(String name, BigDecimal priceValue, BigDecimal discountValue) {
        return new Product(name, priceValue, discountValue);
    }

    public void writeProductInDataBase(Product product) {
        pim.insert(product);
    }

    public void setProductDescription(Product product, String productDiscription) {
        product.setDescription(productDiscription);
    }

    public void setProductCategory(Product product, Category category) {
        product.setCategory(category);
    }

    public Product getProductFromDataBase(Long productID) {
        return pim.get(productID);
    }

    public Product getProductFromDataBase(String productName) {
        return pim.get(productName);
    }

    public List<Product> getProductList(Category category) {
        return pim.getProductList(category);
    }

    public void deleteProductFromDataBase(Product product) {
        pim.delete(product);
    }

}
