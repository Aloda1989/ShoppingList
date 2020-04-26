package shoppingList.validation;


import org.springframework.stereotype.Component;
import shoppingList.domain.Product;
import shoppingList.repository.ProductInMemoryInterface;

import java.util.Optional;

@Component
public class ProductAvailabilityValidation {

    private ProductInMemoryInterface pimi;

    public ProductAvailabilityValidation(ProductInMemoryInterface pimi) {
        this.pimi = pimi;
    }

    public boolean validate(Product product) throws ProductValidationException {

        if (product != null) {
            throw new ProductValidationException("No Product with such name found!");
        }
        Optional<Product> foundProduct = pimi.get(product.getName());
        if (foundProduct != null) {
            if (foundProduct != null) {
                throw new ProductValidationException("In database with is a product with entered name!");
            }
        }
        return true;
    }
}

