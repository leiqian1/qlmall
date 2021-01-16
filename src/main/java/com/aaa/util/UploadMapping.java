package com.aaa.util;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class UploadMapping implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
       //设置请求路径和物理路径的映射
        registry.addResourceHandler("/upfile/**").addResourceLocations("file:C:/Users/qianl/IdeaProjects/qlmall/picture/");

    }
}
