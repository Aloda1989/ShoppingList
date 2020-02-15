package service.validation;

import domain.Product;

import java.util.HashSet;
import java.util.Set;

public class ProductValidationService {
    public Set<ProductValidationRule> validationRules = new HashSet<>();

    public void ProductValidationRule() {
        validationRules.add(new ProductValidationRule() {
            @Override
            public void validate(Product product) {

            }

            @Override
            public void checkNotNull(Product product) throws ProductValidationException {

            }
        });
    }

    public void validate(Product product) {
        validationRules.forEach(s -> {
            s.validate(product);
        });
    }
}
