package shoppingList.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import shoppingList.dto.ProductDTO;
import shoppingList.mapper.ProductConverter;
import shoppingList.repository.ProductInMemoryInterface;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class ProductService {
    private final ProductInMemoryInterface productInMemoryInterface;
    ProductConverter productConverter;

    @Autowired
    public ProductService(ProductInMemoryInterface productInMemoryInterface) {
        this.productInMemoryInterface = productInMemoryInterface;
    }

    @Transactional
    public Product createProduct(String name, BigDecimal priceValue, BigDecimal discountValue) {
        return new Product(name, priceValue, discountValue);
    }

    public void writeProductInDataBase(Product product) {
        productInMemoryInterface.insert(product);
    }

    public void setProductDescription(Product product, String productDescription) {
        product.setDescription(productDescription);
    }

    public void setProductCategory(Product product, Category category) {
        product.setCategory(category);
    }

    public Optional<Product> getProductFromDataBase(Long productID) {
        return productInMemoryInterface.get(productID);
    }

    public Optional<Product> getProductFromDataBase(Product product) {
        return productInMemoryInterface.get(product);
    }

    public Optional<Product> getProductList(Category category) {
        return productInMemoryInterface.getProductList(category);
    }

    public void deleteProductFromDataBase(Optional<Product> product) {
        productInMemoryInterface.delete(product);

    }

    public Optional<Product> getProductFromDataBase(String product) {
        return productInMemoryInterface.get(product);
    }

    public Product findProductById(Long id) {
        return productInMemoryInterface.get(id)
                .orElseThrow(() -> new IllegalArgumentException("Task not found, id: " + id));
    }

    public void updateProduct(ProductDTO productDTO) {
        Product product = productConverter.convert(productDTO);
        productInMemoryInterface.update(product);
    }

    @Transactional
    public void deleteProduct(Long id) {
        productInMemoryInterface.get(id)
                .ifPresent(productInMemoryInterface::delete);
    }

    public ProductDTO findProductByName(String name) {
        return productInMemoryInterface.get(name)
                .map(productConverter::convert)
                .orElseThrow(() -> new NoSuchElementException("Task not found, name: " + name));

    }


}
