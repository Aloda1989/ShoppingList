package shoppingList.validation;


import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PriceValidation {
    public static void validate(BigDecimal productPrice) throws ProductValidationException {

        if (productPrice.intValue() <= 0) {
            throw new ProductValidationException("Product price must be greater than 0!");
        }
    }
}
