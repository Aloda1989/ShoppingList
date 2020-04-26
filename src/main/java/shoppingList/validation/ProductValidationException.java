package shoppingList.validation;

import org.springframework.stereotype.Component;

@Component
public class ProductValidationException extends Throwable {
    ProductValidationException(String message) {
        super(message);
    }
}
