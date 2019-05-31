package com.drxzt.asciimovie.config;

/**
 * className MyWebAppConfigurer
 * description TODO
 *
 * @author DR XZT
 * @version 1.0
 * @date 2019/4/3 17:12
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 资源映射路径
 */
@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {
    /**
     * 图片资源映射
     */
    private final static String PATTERN_IMG = "/img/**";
    //private final static String LOCATION_IMG = "file:/usr/local/Data/";
    private final static String LOCATION_IMG = "file:D:/IdeaProjects/file/";


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //静态资源
        registry.addResourceHandler(PATTERN_IMG).addResourceLocations(LOCATION_IMG);
        registry.addResourceHandler(PATTERN_IMG).addResourceLocations(LOCATION_IMG);
    }
}
