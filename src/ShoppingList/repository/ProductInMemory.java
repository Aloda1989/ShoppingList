package repository;

import domain.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductInMemory {
    private Long productIdSequence = 0L;
    private Map<Long, Product> products = new HashMap<>();

    public Product insert(Product product) {
        product.setId(productIdSequence++);
        products.put(product.getId(), product);
        return product;
    }

    public Product findProductById(Long id) {
        return products.get(id);
    }
}
