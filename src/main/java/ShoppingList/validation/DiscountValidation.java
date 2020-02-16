package ShoppingList.validation;

import java.math.BigDecimal;

public class DiscountValidation {
    public static void validate(BigDecimal productDiscount) throws ProductValidationException {

        if (productDiscount.intValue() < 0 || productDiscount.intValue() > 100) {
            throw new ProductValidationException("Discount cannot be more than 100 percent!");
        }

    }
}
