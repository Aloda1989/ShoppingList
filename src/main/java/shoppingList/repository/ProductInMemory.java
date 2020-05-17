//package shoppingList.repository;
//
//import org.springframework.context.annotation.Profile;
//import org.springframework.stereotype.Repository;
//import shoppingList.domain.Category;
//import shoppingList.domain.Product;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.function.Predicate;
//import java.util.stream.Collectors;
//
//@Repository
//@Profile("inmemory")
//public class ProductInMemory implements ProductInMemoryInterface {
//    private List<Product> pim = new ArrayList<>();
//    private Long taskIdSequence = 0L;
//
//
//    @Override
//    public Optional<Product> get(Product insideProduct) {
//
//        if (pim.contains(insideProduct)) {
//            return Optional.ofNullable(pim.get(pim.indexOf(insideProduct)));
//        } else {
//            return null;
//        }
//
//    }
//
//    @Override
//    public Optional<Product> get(String productName) {
//
//        Predicate<Product> byName = product -> product.getName().equals(productName);
//        List<Product> result = pim.stream().filter(byName).collect(Collectors.toList());
//        if (!(result.size() == 0)) {
//            return Optional.ofNullable(result.get(0));
//        } else {
//            return Optional.empty();
//        }
//
//    }
//
//    public Optional<Product> getProductList(Category category) {
//        List<Product> products = pim.stream()
//                .filter(product -> product.getCategory().equals(category))
//                .collect(Collectors.toList());
//        return Optional.ofNullable(products.get(0));
//    }
//
//    @Override
//    public Optional<Product> get(Long productID) {
//
//        Predicate<Product> byId = product -> product.getId().equals(productID);
//        List<Product> result = pim.stream().filter(byId).collect(Collectors.toList());
//        if (!(result.size() == 0)) {
//            return Optional.ofNullable(result.get(0));
//        } else {
//            return Optional.empty();
//        }
//
//    }
//
//    @Override
//    public void insert(Product product) {
//        product.setId(taskIdSequence++);
//        pim.add(product);
//    }
//
//    @Override
//    public void delete(Optional<Product> product) {
//        pim.remove(product);
//    }
//
//    @Override
//    public void delete(Product product) {
//        pim.remove(product);
//    }
//
//    @Override
//    public void update(Product product) {
//
//    }
//
//
//    @Override
//    public String toString() {
//        return "Product {" +
//                "Product=" + pim.toString() +
//                '}';
//    }
//}