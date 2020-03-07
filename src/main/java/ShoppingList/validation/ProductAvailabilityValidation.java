package ShoppingList.validation;

import ShoppingList.domain.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductAvailabilityValidation {

    private Product product;

    public ProductAvailabilityValidation(Product pim) {
        this.product = pim;
    }

    public boolean validate(Product product) throws ProductValidationException {

        String foundProduct = product.getName();
        if (foundProduct != null) {
            throw new ProductValidationException("No Product with such name found!");

        }

        return true;

    }
}
