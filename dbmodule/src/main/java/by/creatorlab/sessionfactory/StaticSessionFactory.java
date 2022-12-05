package by.creatorlab.sessionfactory;

import by.creatorlab.configuration.DataConfig;
import by.creatorlab.configuration.MysqlSessionFactory;
import org.hibernate.SessionFactory;

public class StaticSessionFactory {
    private final static SessionFactory sessionFactory = MysqlSessionFactory
            .getInstance(DataConfig.JDBC_PROPERTIES,DataConfig.HIBERNATE_PROPERTIES);
    public static SessionFactory getInstance() {
        return sessionFactory;
    }
}
