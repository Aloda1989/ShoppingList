package shoppingList.validation;

import ShoppingList.domain.Product;
import ShoppingList.validation.ProductValidationException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class NameValidationRuleTest {
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldThrowTaskValidationException() {
        Product input = product();
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Task name must be not null.");
    }

    private Product product() {
        Product product = new Product();
        product.setName(null);
        return product;
    }
}