package ShoppingList.service.validation;

public class ProductValidationException extends Throwable {
    ProductValidationException(String errorDescription) {
        super(errorDescription);
    }
}
