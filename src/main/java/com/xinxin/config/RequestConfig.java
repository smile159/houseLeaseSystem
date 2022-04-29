package com.xinxin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author smile
 * @ClassName RequestConfig.java
 * @Description TODO
 * @createTime 2022年04月28日 11:31:00
 */
@Configuration
public class RequestConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestLog())
            .addPathPatterns("/**");
    }
}

