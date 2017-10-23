package com.app_service.dao.configuration;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(basePackages = "com.leyao.app_service.dao.mapper.hs_event", sqlSessionFactoryRef = "hsEventSqlSessionFactory")
public class HsEventDataSourceConfig {

    @Bean(name = "hsEventDataSource")
    @ConfigurationProperties("datasource.hs_event")
    public DataSource masterDataSource() {
        DataSource dataSource=DataSourceBuilder.create().build();
        return dataSource;
    }

    @Bean(name = "hsEventSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("hsEventDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/master/*.xml"));
        return sessionFactoryBean.getObject();
    }
}