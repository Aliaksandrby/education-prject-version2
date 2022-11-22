package by.creatorlab.config;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class MysqlJdbcDataSource {

    private final String propertyFile;

    @SneakyThrows
    public MysqlJdbcDataSource(String propertyFile) {
        this.propertyFile = propertyFile;
        Class.forName(DataConfig.getJdbcProperties(propertyFile).getProperty("driver"));
    }

    @SneakyThrows
    public Connection getConnection() {
        Properties jdbcProperties = DataConfig.getJdbcProperties(propertyFile);
        return DriverManager.getConnection(
                jdbcProperties.getProperty("url"),
                jdbcProperties.getProperty("username"),
                jdbcProperties.getProperty("password")
        );
    }
}
