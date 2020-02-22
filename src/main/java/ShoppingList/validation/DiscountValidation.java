package ShoppingList.validation;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DiscountValidation {
    public static void validate(BigDecimal productDiscount) throws ProductValidationException {

        if (productDiscount.intValue() < 0 || productDiscount.intValue() > 100) {
            throw new ProductValidationException("Discount cannot be more than 100 percent!");
        }

    }
}
