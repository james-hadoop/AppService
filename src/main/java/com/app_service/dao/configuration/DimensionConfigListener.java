package com.app_service.dao.configuration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app_service.service.IDimensionConfigService;

public class DimensionConfigListener implements ServletContextListener {
    private static final Logger log = LoggerFactory.getLogger(DimensionConfigListener.class);

    @Autowired
    private IDimensionConfigService dimensionConfigService;
    
    public DimensionConfigListener() {
        super();
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContex初始化");

        try {
            dimensionConfigService = WebApplicationContextUtils
                    .getRequiredWebApplicationContext(sce.getServletContext()).getBean(IDimensionConfigService.class);

            dimensionConfigService.initDimensionConfig();
        } catch (Exception e) {
            log.info("DimensionConfigListener initialization failed:" + e);
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContex销毁");
    }
}