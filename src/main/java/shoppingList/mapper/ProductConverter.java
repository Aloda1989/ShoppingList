package shoppingList.mapper;

import org.springframework.stereotype.Component;
import shoppingList.domain.Product;
import shoppingList.dto.ProductDTO;

@Component
public class ProductConverter {
    public Product convert(ProductDTO productDTO) {
        Product product = new Product();
        product.setDescription(productDTO.getDescription());
        product.setName(productDTO.getName());
        product.setId(productDTO.getId());
        return product;
    }

    public ProductDTO convert(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setDescription(product.getDescription());
        productDTO.setName(product.getName());
        productDTO.setId(product.getId());
        return productDTO;
    }
}
