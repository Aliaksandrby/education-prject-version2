package by.creatorlab.config;

import by.creatorlab.entities.Car;
import by.creatorlab.entities.ImageCar;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.HashMap;
import java.util.Map;

public final class MysqlSessionFactory {

    private static SessionFactory sessionFactory;

    public static SessionFactory getInstance(String jdbcProperties,String hibernateProperties) {
        if (sessionFactory != null) {
            return sessionFactory;
        }

        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .applySettings(buildSettings(jdbcProperties, hibernateProperties))
                .build();

        Metadata metadata = new MetadataSources(standardRegistry)
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(ImageCar.class)
                .getMetadataBuilder()
                .build();

        sessionFactory = metadata.getSessionFactoryBuilder().build();

        return sessionFactory;
    }

    private static Map<String, String> buildSettings(String jdbcProperties, String hibernateProperties) {
        Map<String, String> settings = new HashMap<>();
        settings.put("connection.driver_class",
                DataConfig.getJdbcProperties(jdbcProperties).getProperty("driver"));
        settings.put("hibernate.connection.url",
                DataConfig.getJdbcProperties(jdbcProperties).getProperty("url"));
        settings.put("hibernate.connection.username",
                DataConfig.getJdbcProperties(jdbcProperties).getProperty("username"));
        settings.put("hibernate.connection.password",
                DataConfig.getJdbcProperties(jdbcProperties).getProperty("password"));

        settings.put("dialect",
                DataConfig.getHibernateProperties(hibernateProperties).getProperty("dialect"));
        settings.put("hibernate.current_session_context_class",
                DataConfig.getHibernateProperties(hibernateProperties).getProperty("hibernate.current_session_context_class"));
        settings.put("hibernate.show_sql",
                DataConfig.getHibernateProperties(hibernateProperties).getProperty("hibernate.show_sql"));
        settings.put("hibernate.format_sql",
                DataConfig.getHibernateProperties(hibernateProperties).getProperty("hibernate.format_sql"));
        return settings;
    }

}
