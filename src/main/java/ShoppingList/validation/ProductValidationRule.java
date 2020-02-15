package ShoppingList.validation;

import ShoppingList.domain.Product;
import ShoppingList.repository.ProductInMemoryInterface;


public class ProductValidationRule {
    private ProductInMemoryInterface pim;

    public ProductValidationRule(ProductInMemoryInterface pim) {
        this.pim = pim;
    }

    public boolean validate(Product product) throws ProductValidationException {

        Product foundProduct = pim.get(product.getName());
        if (foundProduct != null) {
            throw new ProductValidationException("In database with is a product with entered name!");

        }

        return true;

    }
}
