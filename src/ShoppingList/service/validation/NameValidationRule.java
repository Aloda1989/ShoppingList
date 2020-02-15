package service.validation;

import domain.Product;

public class NameValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) throws ProductValidationException {
        checkNotNull(product);
        if (product.getName() == null) {
            throw new ProductValidationException("Task name must be not null.");
        }
    }

    @Override
    public void checkNotNull(Product product) {

    }
}
