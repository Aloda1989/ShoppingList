package shoppingList.validation;

public class ProductValidationException extends RuntimeException {
    ProductValidationException(String errorDescription) {
        super(errorDescription);
    }
}
