package ShoppingList.service.validation;

public class NameValidationRule implements ProductValidationRule {

    public static void validate(String productName) throws ProductValidationException {

        if ((productName.length() < 3 || productName.length() > 32)) {
            throw new ProductValidationException("Name cannot be less than 3 characters and more than 32!");
        }
    }
}
