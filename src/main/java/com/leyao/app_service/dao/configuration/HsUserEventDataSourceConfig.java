package com.leyao.app_service.dao.configuration;

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
@MapperScan(basePackages = "com.leyao.app_service.dao.mapper.ls_user_event", sqlSessionFactoryRef = "hsEventSqlSessionFactory")
public class HsUserEventDataSourceConfig {

    @Bean(name = "hsUserEventDataSource")
    @ConfigurationProperties("datasource.ls_user_event")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "hsUserEventSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("hsUserEventDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/master/*.xml"));
        return sessionFactoryBean.getObject();
    }
}