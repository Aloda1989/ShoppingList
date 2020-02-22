package ShoppingList.repository;

import ShoppingList.domain.Category;
import ShoppingList.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Repository
public class ProductInMemory implements ProductInMemoryInterface {
    private List<Product> pim = new ArrayList<>();

    @Override
    public Product get(Product insideProduct) {

        if (pim.contains(insideProduct)) {
            return pim.get(pim.indexOf(insideProduct));
        } else {
            return Product.emptyProduct;
        }

    }

    @Override
    public Product get(String productName) {

        Predicate<Product> byName = product -> product.getName().equals(productName);
        var result = pim.stream().filter(byName).collect(Collectors.toList());
        if (!(result.size() == 0)) {
            return result.get(0);
        } else {
            return Product.emptyProduct;
        }

    }

    public List<Product> getProductList(Category category) {

        return pim.stream()
                .filter(product -> product.getCategory().equals(category))
                .collect(Collectors.toList());

    }


    @Override
    public Product get(Long productID) {

        Predicate<Product> byId = product -> product.getId().equals(productID);
        var result = pim.stream().filter(byId).collect(Collectors.toList());
        if (!(result.size() == 0)) {
            return result.get(0);
        } else {
            return Product.emptyProduct;
        }

    }


    @Override
    public void insert(Product product) {
        pim.add(product);
    }

    @Override
    public void update(Product product) {

        pim.set(pim.indexOf(product), product);

    }

    @Override
    public void delete(Product product) {
        pim.remove(product);
    }

    @Override
    public String toString() {
        return "Product {" +
                "dB=" + pim.toString() +
                '}';
    }
}
