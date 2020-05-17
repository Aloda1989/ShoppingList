package shoppingList;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import shoppingList.upaimpl.AccountUpaImpl;
import shoppingList.upaimpl.OrderUpaImpl;
import shoppingList.upaimpl.ProductUpaImpl;
import shoppingList.userproductactions.AccountUpa;
import shoppingList.userproductactions.OrderUpa;
import shoppingList.userproductactions.ProductUpa;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("shoppingList.*")
@PropertySource("classpath:app.properties")
@EnableTransactionManagement
public class AppConfig {
    @Autowired
    private Environment environment;

    @Bean
    public Properties hibernateProperties(
            @Value("${hibernate.dialect}") String dialect,
            @Value("${hibernate.show_sql}") boolean showSql,
            @Value("${hibernate.format_sql}") boolean formatSql,
            @Value("${hibernate.hbm2ddl.auto}") String hbm2ddl) {

        Properties properties = new Properties();
        properties.put("hibernate.dialect", dialect);
        properties.put("hibernate.show_sql", showSql);
        properties.put("hibernate.format_sql", formatSql);
        properties.put("hibernate.hbm2ddl.auto", hbm2ddl);

        return properties;
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setBasenames(new String[]{"messages/validator"});
        return resourceBundleMessageSource;
    }

    @Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        return commonsMultipartResolver;
    }

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("ds.database-driver"));
        dataSource.setUrl(environment.getProperty("ds.url"));
        dataSource.setUsername(environment.getProperty("ds.username"));
        dataSource.setPassword(environment.getProperty("ds.password"));
        System.out.println("## getDataSource: " + dataSource);
        return dataSource;
    }

    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
        properties.put("current_session_context_class", environment.getProperty("current_session_context_class"));

        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

        factoryBean.setPackagesToScan(new String[]{"shoppingList.entity"});
        factoryBean.setDataSource(dataSource);
        factoryBean.setHibernateProperties(properties);
        factoryBean.afterPropertiesSet();

        SessionFactory sessionFactory = factoryBean.getObject();
        System.out.println("## getSessionFactory: " + sessionFactory);
        return sessionFactory;
    }

    @Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
        return transactionManager;
    }

    @Bean(name = "accountUpa")
    public AccountUpa getApplicantUpa() {
        return new AccountUpaImpl();
    }

    @Bean(name = "productUpa")
    public ProductUpa getProductUpa() {
        return new ProductUpaImpl();
    }

    @Bean(name = "orderUpa")
    public OrderUpa getOrderUpa() {
        return new OrderUpaImpl();
    }

    @Bean(name = "accountUpa")
    public AccountUpa getAccountUpa() {
        return new AccountUpaImpl();
    }
}
