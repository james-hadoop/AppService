package com.leyao.app_service;

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class, MybatisAutoConfiguration.class })
@PropertySources({ @PropertySource("classpath:application.properties"),
        @PropertySource(value = "file:${external.config}", ignoreResourceNotFound = true) })
public class Application implements CommandLineRunner, EmbeddedServletContainerCustomizer {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.addListeners(new SpringApplicationStartup());
        springApplication.run(args);

        // SpringApplication.run(Application.class, args);
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(8088);
    }

    @Override
    public void run(String... arg0) throws Exception {
        // TODO Auto-generated method stub

    }
}