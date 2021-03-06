//package shoppingList.repository;
//
//import org.hibernate.SessionFactory;
//import org.hibernate.criterion.Restrictions;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Profile;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//import shoppingList.domain.Category;
//import shoppingList.domain.Product;
//
//import java.util.Optional;
//
//@Repository
//@Profile("hibernate")
//@Transactional
//class ProductInHibernate implements ProductInMemoryInterface {
//
//    private final SessionFactory sessionFactory;
//
//    @Autowired
//    public ProductInHibernate(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    @Override
//    public Optional<Product> get(Product insideProduct) {
//
//        Product product = (Product) sessionFactory.getCurrentSession().createCriteria(Product.class)
//                .add(Restrictions.eq("id", insideProduct.getId()))
//                .uniqueResult();
//        return Optional.ofNullable(product);
//    }
//
//
//
//    @Override
//    public Optional<Product> get(String productName) {
//
//        Product product = (Product) sessionFactory.getCurrentSession().createCriteria(Product.class)
//                .add(Restrictions.eq("name", productName))
//                .uniqueResult();
//        return Optional.ofNullable(product);
//
//    }
//
//    @Override
//    public Optional<Product> getProductList(Category category) {
//        Product product = (Product) sessionFactory.getCurrentSession().createCriteria(Product.class)
//                .add(Restrictions.eq("category", category))
//                .uniqueResult();
//        return Optional.ofNullable(product);
//
//    }
//
//
//    @Override
//    public Optional<Product> get(Long productID) {
//
//        Product product = (Product) sessionFactory.getCurrentSession().createCriteria(Product.class)
//                .add(Restrictions.eq("id", productID))
//                .uniqueResult();
//        return Optional.ofNullable(product);
//
//    }
//
//
//    @Override
//    public void insert(Product product) {
//        sessionFactory.getCurrentSession().save(product);
//    }
//
//
//    @Override
//    public void delete(Optional<Product> product) {
//        sessionFactory.getCurrentSession().delete(product);
//    }
//
//    @Override
//    public void delete(Product product) {
//        sessionFactory.getCurrentSession().delete(product);
//    }
//
//    @Override
//    public void update(Product product) {
//
//    }
//}
