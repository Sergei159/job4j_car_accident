package ru.job4j.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@PropertySource("classpath:app.properties")
public class DataConfig {

    @Bean
    public DataSource ds(@Value("${spring.datasource.driver}") String driver,
                         @Value("${spring.datasource.url}") String url,
                         @Value("${spring.datasource.username}") String username,
                         @Value("${spring.datasource.password}") String password) {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }
    @Bean
    public JdbcTemplate jdbc(DataSource ds) {
        return new JdbcTemplate(ds);
    }

    @Bean
    public SessionFactory initSessionFactory() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        return new MetadataSources(registry)
                .buildMetadata().buildSessionFactory();
    }
}