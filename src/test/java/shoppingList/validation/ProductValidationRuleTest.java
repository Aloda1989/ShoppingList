package shoppingList.validation;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import shoppingList.domain.Product;
import shoppingList.repository.ProductInMemoryInterface;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ProductValidationRuleTest {
    private ProductInMemoryInterface pim;

    private ProductAvailabilityValidation service;

    @Before
    public void setup() {
        pim = Mockito.mock(ProductInMemoryInterface.class);
        service = new ProductAvailabilityValidation((Product) pim);
    }

    @Test
    public void shouldReturnErrorWhenProductAlreadyExist() {

        Product testProduct = new Product("asus", new BigDecimal("2.41"), new BigDecimal("2.41"));
        Product foundProduct = new Product("acer", new BigDecimal("5.12"), new BigDecimal("5.12"));
        Mockito.when(pim.get("asus")).thenReturn(foundProduct);

        try {
            service.validate(testProduct);
            fail();
        } catch (ProductValidationException e) {

            assertEquals(e.getMessage(), "In database with is a product with entered name!");
        }
    }
}