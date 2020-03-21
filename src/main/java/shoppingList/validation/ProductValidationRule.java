package shoppingList.validation;

import org.springframework.stereotype.Service;
import shoppingList.repository.ProductInMemoryInterface;

@Service

public class ProductValidationRule {
    private ProductInMemoryInterface pim;

    public ProductValidationRule(ProductInMemoryInterface pim) {
        this.pim = pim;
    }

}
