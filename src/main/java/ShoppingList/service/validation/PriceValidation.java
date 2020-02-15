package ShoppingList.service.validation;

import java.math.BigDecimal;

public class PriceValidation {
    public static void validate(BigDecimal productPrice) throws ProductValidationException {

        if (productPrice.intValue() <= 0) {
            throw new ProductValidationException("Product price must be greater than 0!");
        }
    }
}