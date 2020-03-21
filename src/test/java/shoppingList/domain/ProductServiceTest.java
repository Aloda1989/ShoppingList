package shoppingList.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import shoppingList.consoleui.ProductService;
import shoppingList.repository.ProductInMemory;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    private ProductInMemory repository;
    @InjectMocks
    private ProductService victim;

    @Test
    public void shouldFindTask() {
        when(repository.get(1001L)).thenReturn(product());
        Product result = victim.getProductFromDataBase(1001L);
        assertEquals(product(), result);
    }

    private Product product() {
        Product product = new Product();
        product.setName("Name");
        BigDecimal price = new BigDecimal("0.03");
        product.setPrice(price);
        BigDecimal discount = new BigDecimal("0.56");
        product.setDiscount(discount);
        product.setDescription("Description");
        product.setId(1001L);
        return product;
    }
}