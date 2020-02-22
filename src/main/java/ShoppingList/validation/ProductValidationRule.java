package ShoppingList.validation;

import ShoppingList.repository.ProductInMemoryInterface;
import org.springframework.stereotype.Service;

@Service

public class ProductValidationRule {
    private ProductInMemoryInterface pim;

    public ProductValidationRule(ProductInMemoryInterface pim) {
        this.pim = pim;
    }

}
