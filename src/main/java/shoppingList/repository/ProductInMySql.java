//package shoppingList.repository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Profile;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.support.GeneratedKeyHolder;
//import org.springframework.jdbc.support.KeyHolder;
//import org.springframework.stereotype.Component;
//import shoppingList.domain.Category;
//import shoppingList.domain.Product;
//
//import java.sql.PreparedStatement;
//import java.sql.Statement;
//import java.util.List;
//import java.util.Optional;
//
//@Component
//@Profile("MySql")
//public class ProductInMySql implements ProductInMemoryInterface {
//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    ProductInMySql(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    @Override
//    public Optional<Product> get(Product product) {
//
//        String query = "select * from product.product where id=?";
//        List<Object> products = jdbcTemplate.query(query,
//                new BeanPropertyRowMapper(Product.class), product.getId());
//        if (!products.isEmpty()) {
//            //return Optional.ofNullable(products.get(0));
//        }
//        return Optional.empty();
//
//
//    }
//
//    @Override
//    public Optional<Product> get(String productName) {
//
//        String query = "select * from product.product where name =?";
//        List<Object> products = jdbcTemplate.query(query,
//                new BeanPropertyRowMapper(Product.class), productName);
//        if (!products.isEmpty()) {
//            //return Optional.ofNullable(products.get(0));
//        }
//        return Optional.empty();
//
//    }
//
//    @Override
//    public Optional<Product> getProductList(Category category) {
//        String query = "select * from product.listofcategory where category =?";
//        List<Object> products = jdbcTemplate.query(query,
//                new BeanPropertyRowMapper(Product.class), category);
//        if (!products.isEmpty()) {
//            //return Optional.ofNullable(products.get(0));
//        }
//        return Optional.empty();
//
//    }
//
//
//    @Override
//    public Optional<Product> get(Long productID) {
//
//        String query = "select * from product.product where id=?";
//        List<Object> products = jdbcTemplate.query(query,
//                new BeanPropertyRowMapper(Product.class), productID);
//        if (!products.isEmpty()) {
//            //return Optional.ofNullable(products.get(0));
//        }
//        return Optional.empty();
//
//    }
//
//
//    @Override
//    public void insert(Product product) {
//
//        String query = "insert into product.product (name, description, price, discount) values (" +
//                "?, ?, ?, ?)";
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//
//        jdbcTemplate.update(connection -> {
//            PreparedStatement ps = connection
//                    .prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//            ps.setString(1, product.getName());
//            ps.setString(2, product.getDescription());
//            ps.setBigDecimal(3, product.getPrice());
//            ps.setBigDecimal(4, product.getDiscount());
//            return ps;
//        }, keyHolder);
//
//        product.setId(keyHolder.getKey().longValue());
//
//
//    }
//
//    @Override
//    public void delete(Optional<Product> product) {
//        String query = "delete from product.product where id=?";
//        jdbcTemplate.query(query,
//                new BeanPropertyRowMapper(Product.class), product.get().getId());
//
//
//    }
//
//
//    @Override
//    public void delete(Product product) {
//        String query = "delete from product.product where id=?";
//        jdbcTemplate.query(query,
//                new BeanPropertyRowMapper(Product.class), product.getId());
//    }
//
//    @Override
//    public void update(Product product) {
//
//    }
//}
