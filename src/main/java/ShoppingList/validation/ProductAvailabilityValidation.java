package ShoppingList.validation;

import ShoppingList.domain.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductAvailabilityValidation {

    private Product pim;

    public ProductAvailabilityValidation(Product pim) {
        this.pim = pim;
    }

    public boolean validate(Product product) throws ProductValidationException {

        String foundProduct = pim.getName();
        if (foundProduct != null) {
            throw new ProductValidationException("No Product with such name found!");

        }

        return true;

    }
}
