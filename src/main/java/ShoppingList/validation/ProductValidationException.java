package ShoppingList.validation;

public class ProductValidationException extends Throwable {
    ProductValidationException(String errorDescription) {
        super(errorDescription);
    }
}
