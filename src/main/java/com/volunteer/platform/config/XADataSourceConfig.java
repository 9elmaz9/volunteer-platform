///
///
///package com.volunteer.platform.config;
///
///import com.atomikos.jdbc.AtomikosDataSourceBean;
///import com.mysql.cj.jdbc.MysqlXADataSource;
///import org.springframework.context.annotation.Bean;
///import org.springframework.context.annotation.Configuration;
///import org.springframework.transaction.PlatformTransactionManager;
///import org.springframework.transaction.annotation.EnableTransactionManagement;
///import org.springframework.transaction.jta.JtaTransactionManager;
///
///import javax.sql.DataSource;
///import java.sql.SQLException;
///
///@Configuration
///@EnableTransactionManagement
///public class XADataSourceConfig {
///
///    @Bean
///    public DataSource dataSource() throws SQLException {
///        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
///        mysqlXADataSource.setUrl("jdbc:mysql://localhost:3306/volunteer_platform");
///        mysqlXADataSource.setUser("big_boss");
///        mysqlXADataSource.setPassword("1234567");
///
///        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
///        xaDataSource.setXaDataSource(mysqlXADataSource);
///        xaDataSource.setUniqueResourceName("xaDataSource");
///        xaDataSource.setMinPoolSize(5);
///        xaDataSource.setMaxPoolSize(10);
///
///        return xaDataSource;
///    }
///
///    @Bean
///    public PlatformTransactionManager transactionManager() {
///        return new JtaTransactionManager();
///    }
///}
///# JTA properties
///spring.datasource.jta-managed=true
///spring.jta.atomikos.datasource.unique-resource-name=xaDataSource
///spring.jta.atomikos.datasource.xa-data-source-class=com.mysql.cj.jdbc.MysqlXADataSource
///spring.jta.atomikos.datasource.xa-properties.user=big_boss
///spring.jta.atomikos.datasource.xa-properties.password=1234567
///spring.jta.atomikos.datasource.xa-properties.url=jdbc:mysql://localhost:3306/volunteer_platform
///spring.jta.atomikos.datasource.min-pool-size=5
///spring.jta.atomikos.datasource.max-pool-size=10
///spring.jta.atomikos.datasource.borrow-connection-timeout=30
///
///spring.jpa.properties.hibernate.transaction.coordinator_class=jta
///spring.jpa.properties.hibernate.transaction.jta.platform=org.springframework.boot.jta.atomikos.AtomikosJtaPlatform
///spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true
///
///
///<dependency>
///			<groupId>com.atomikos</groupId>
///			<artifactId>transactions-jta</artifactId>
///			<version>5.0.8</version>
///		</dependency>
///		<dependency>
///			<groupId>com.atomikos</groupId>
///			<artifactId>transactions-jdbc</artifactId>
///			<version>5.0.8</version>
///		</dependency>
///
///		<dependency>
///			<groupId>mysql</groupId>
///			<artifactId>mysql-connector-java</artifactId>
///			<version>8.0.26</version>
///		</dependency>
///		<dependency>
///			<groupId>org.springframework.boot</groupId>
///			<artifactId>spring-boot-starter-jta-atomikos</artifactId>
///			<version>2.6.2</version>
///		</dependency>