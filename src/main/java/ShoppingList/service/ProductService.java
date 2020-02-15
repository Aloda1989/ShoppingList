package ShoppingList.service;

import ShoppingList.domain.Product;
import ShoppingList.repository.ProductInMemory;
import ShoppingList.service.validation.ProductValidationService;

public class ProductService {
    private ProductInMemory pim = new ProductInMemory();
    private ProductValidationService vs = new ProductValidationService();

    public Long createProduct(Product product) {
        vs.validate(product);
        Product createdProduct = pim.insert(product);
        return createdProduct.getId();
    }

    public Product findProductById(long id) {
        return pim.findProductById(id);
    }

}
