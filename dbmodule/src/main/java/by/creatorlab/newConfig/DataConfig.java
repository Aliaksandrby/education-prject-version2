package by.creatorlab.newConfig;

import by.creatorlab.model.Car;
import by.creatorlab.model.ImageCar;
import lombok.SneakyThrows;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "by.creator")
@PropertySource(value = {
        "classpath:/jdbc.properties",
        "classpath:/hibernate.properties"
})
@EnableTransactionManagement
public class DataConfig {

    public static final String JDBC_PROPERTIES_FILE_NAME = "jdbc.properties";
    public static final String HIBERNATE_PROPERTIES_FILE_NAME = "hibernate.properties";

    private static Properties jdbcProperties;


    @SneakyThrows
    public static Properties getJdbcProperties(String propertyFileName) {
        if (jdbcProperties == null) {
            jdbcProperties = new Properties();
            jdbcProperties.load(MysqlJdbcDataSource.class
                    .getClassLoader()
                    .getResourceAsStream(propertyFileName));
        }
        return jdbcProperties;
    }

    @Bean
    public Properties hibernateProperties(
            @Value("${hibernate.show_sql}") String showSql,
            @Value("true") String debug,
            @Value("${dialect}") String dialect,
            @Value("${hibernate.format_sql}") String format
    ) {
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.show_sql", showSql);
        hibernateProperties.put("debug", debug);
        hibernateProperties.put("hibernate.dialect", dialect);
        hibernateProperties.put("hibernate.format_sql", format);

        return hibernateProperties;
    }

    @Bean
    public DataSource dataSource(
            @Value("${url}") String url,
            @Value("${driver}") String driverClassName,
            @Value("root") String userName,
            @Value("${password}") String password,
            @Value("true") boolean removeAbandonedOnBorrow,
            @Value("50") int initialSize,
            @Value("100") int maxTotal) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setRemoveAbandonedOnBorrow(removeAbandonedOnBorrow);
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxTotal(maxTotal);
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource,
                                                  Properties hibernateProperties) {
        LocalSessionFactoryBean sessionFactory =
                new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setAnnotatedClasses(
                Car.class,
                ImageCar.class
        );
        sessionFactory.setHibernateProperties(hibernateProperties);
        return sessionFactory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }
}
