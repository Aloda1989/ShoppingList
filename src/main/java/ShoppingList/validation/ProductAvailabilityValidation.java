package ShoppingList.validation;

import ShoppingList.domain.Product;

public class ProductAvailabilityValidation {

    // TODO: do not store product there!
    // Use a product received as a parameter for validate method!
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
