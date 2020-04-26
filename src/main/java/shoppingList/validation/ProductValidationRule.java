package shoppingList.validation;

import org.springframework.stereotype.Component;
import shoppingList.repository.ProductInMemoryInterface;

@Component

public class ProductValidationRule {
    private ProductInMemoryInterface pim;

    public ProductValidationRule(ProductInMemoryInterface pim) {
        this.pim = pim;
    }

}
