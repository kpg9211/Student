package com.Mark1.Urvashi.db2Config;


import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "studentManagerFactory",
        basePackages = {"com.Mark1.Urvashi.db2Dao"})
public class StudentConfig {


   /* @Primary
    @Bean(name="studentDataSource")
    @ConfigurationProperties(prefix="sprng.db2.datasource")
    public DataSource studentDataSource(){
       *//* DriverManagerDataSource dataSource= new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("spring.db2.datasource.jdbc-url"));
        dataSource.setDriverClassName(env.getProperty("spring.db2.datasource.driverClassName"));
        dataSource.setPassword(env.getProperty("spring.db2.datasource.password"));
        dataSource.setUsername(env.getProperty("spring.db2.datasource.username"));
        return dataSource;*//*

        return DataSourceBuilder.create().build();
    }*/
/*
* EntityManagerFactoryBuilder builder,@Qualifier("StudentDataSource") DataSource dataSource */
    @Primary
    @Bean(name="studentManagerFactory")
    public LocalContainerEntityManagerFactoryBean studentManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("studentDataSource") DataSource dataSource ){


        HashMap<String,Object> properties= new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto","update");
        properties.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        return builder.dataSource(dataSource)
                .properties(properties)
                .packages("com.Mark1.Urvashi.db2Dao")
                .persistenceUnit("student").build();
    }


    @Primary
    @Bean(name="studentTxManager")
    public PlatformTransactionManager studentTxManager(@Qualifier("studentManagerFactory") EntityManagerFactory entityManagerFactory){

        return new JpaTransactionManager(entityManagerFactory);
    }


    @Primary
    @Bean(name="studentDataSourceProperties")
    @ConfigurationProperties("spring.db2.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }


    @Primary
    @Bean(name="studentDataSource")
    @ConfigurationProperties("spring.db2.datasource")
    public HikariDataSource dataSource(@Qualifier("studentDataSourceProperties") DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().type(HikariDataSource.class)
                .build();
    }
}
