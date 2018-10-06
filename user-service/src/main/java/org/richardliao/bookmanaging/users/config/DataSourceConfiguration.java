package org.richardliao.bookmanaging.users.config;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.ApplicationContext;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;

@Configuration
public class DataSourceConfiguration {

    @Bean
    public DataSource driverManagerDataSource() {
	DriverManagerDataSource ds = new DriverManagerDataSource();
	ds.setDriverClassName("com.mysql.jdbc.Driver");
	ds.setUrl("jdbc:mysql://localhost:3306/bookmanaging");
	ds.setUsername("root");
	ds.setPassword("");
	return ds;
    }

    @Bean(name="sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(ApplicationContext applicationContext, DataSource ds) throws Exception {
	SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
	ssfb.setDataSource(ds);
	ssfb.setTypeAliasesPackage("org.richardliao.bookmanaging.users.domain");
	ssfb.setMapperLocations(applicationContext.getResources("classpath:org/richardliao/bookmanaging/users/mapper/UserMapper.xml"));
	return ssfb.getObject();
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
	MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
	mapperScannerConfigurer.setBasePackage("org.richardliao.bookmanaging.users.mapper");
	mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
	return mapperScannerConfigurer;
    }
}
