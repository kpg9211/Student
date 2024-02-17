package com.Mark1.Urvashi.db1Config;



import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "reportCardManagerFactory",
        basePackages = {"com.Mark1.Urvashi.db1Dao"})
public class ReportCardConfig {

   /* @Bean(name="reportCardDataSource")
    @ConfigurationProperties(prefix="spring.db1.datasource")
    public DataSource reportCardDataSource(){
        return DataSourceBuilder.create().build();
    }
*/

    @Bean(name="reportCardManagerFactory")
    public LocalContainerEntityManagerFactoryBean reportCardManagerFactory(EntityManagerFactoryBuilder builder,
                                                                           @Qualifier("reportCardDataSource") DataSource dataSource){
        HashMap<String,Object> properties= new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto","update");
        properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
        return  builder.dataSource(dataSource)
                .properties(properties)
                .packages("com.Mark1.Urvashi.db1Dao")
                .persistenceUnit("reportCard").build();
    }


    @Bean(name="reportCardTxManager")
    public PlatformTransactionManager reportCardTxManager(@Qualifier("reportCardManagerFactory") EntityManagerFactory reportCardManagerFactory){
        return new JpaTransactionManager(reportCardManagerFactory);
    }


    @Bean(name="studentProperties")
    @ConfigurationProperties("spring.db1.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }


    @Bean(name="reportCardDataSource")
    @ConfigurationProperties("spring.db1.datasource")
    public HikariDataSource dataSource(@Qualifier("name=studentProperties") DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().type(HikariDataSource.class)
                .build();
    }
}
