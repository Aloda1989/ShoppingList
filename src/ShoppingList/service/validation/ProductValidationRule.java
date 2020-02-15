package service.validation;

import domain.Product;

public interface ProductValidationRule {
    void validate(Product product);

    void checkNotNull(Product product) throws ProductValidationException;
}
