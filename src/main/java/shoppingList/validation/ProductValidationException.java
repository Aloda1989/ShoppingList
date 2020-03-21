package shoppingList.validation;

public class ProductValidationException extends Throwable {
    ProductValidationException(String message) {
        super(message);
    }
}
