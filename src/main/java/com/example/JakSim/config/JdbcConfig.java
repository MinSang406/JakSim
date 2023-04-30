package com.example.JakSim.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JdbcConfig {
    @Autowired
    private ApplicationContext application;
    @Bean
    public PlatformTransactionManager transactionManager(){
        DataSourceTransactionManager tm = new DataSourceTransactionManager();
        tm.setDataSource(dataSource());

        return tm;
    }

    @Bean
    public DataSource dataSource(){
        DataSource ds = new DataSource();

        ds.setDriverClassName(application.getEnvironment().getRequiredProperty("spring.datasource.driverClassName"));
        ds.setUrl(application.getEnvironment().getRequiredProperty("spring.datasource.url"));
        ds.setUsername(application.getEnvironment().getRequiredProperty("spring.datasource.username"));
        ds.setPassword(application.getEnvironment().getRequiredProperty("spring.datasource.password"));

        ds.setInitialSize(2);
        ds.setMinIdle(3);
        ds.setMaxIdle(3);
        ds.setMaxActive(5);
        ds.setMinEvictableIdleTimeMillis(60000);
        ds.setTimeBetweenEvictionRunsMillis(5000);

        return ds;
    }
}
