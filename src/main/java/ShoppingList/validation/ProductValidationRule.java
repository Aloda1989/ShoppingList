package ShoppingList.validation;

import ShoppingList.repository.ProductInMemoryInterface;


public class ProductValidationRule {
    private ProductInMemoryInterface pim;

    public ProductValidationRule(ProductInMemoryInterface pim) {
        this.pim = pim;
    }

}
