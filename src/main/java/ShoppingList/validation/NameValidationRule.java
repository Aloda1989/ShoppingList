package ShoppingList.validation;

import ShoppingList.repository.ProductInMemoryInterface;
import org.springframework.stereotype.Service;

@Service
public class NameValidationRule extends ProductValidationRule {

    public NameValidationRule(ProductInMemoryInterface pim) {
        super(pim);
    }

    public static void validate(String productName) throws ProductValidationException {

        if ((productName.length() < 3 || productName.length() > 32)) {
            throw new ProductValidationException("Name cannot be less than 3 characters and more than 32!");
        }
    }
}
