package ShoppingList.repository;

import ShoppingList.domain.Product;


public interface ProductInMemoryInterface {
    void insert(Product product);


    void update(Product product);

    void delete(Product product);

    Product get(Product product);

    Product get(String productName);

    Product get(Long productID);


}
