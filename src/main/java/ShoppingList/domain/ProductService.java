package ShoppingList.domain;

import ShoppingList.repository.ProductInMemory;

import java.math.BigDecimal;
import java.util.List;

public class ProductService {
    private ProductInMemory pim;

    public ProductService(ProductInMemory pim) {
        this.pim = pim;
    }

    public Product createProduct(String name, BigDecimal priceValue, BigDecimal discountValue) {
        Product newProduct = new Product(name, priceValue, discountValue);
        return newProduct;
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

    public Product getProductFromDataBase(Product product) {
        return pim.get(product);
    }

    public void deleteProductFromDataBase(Product product) {
        pim.delete(product);
    }

}
