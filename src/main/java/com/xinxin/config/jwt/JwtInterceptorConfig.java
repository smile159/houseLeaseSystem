package com.xinxin.config.jwt;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author smile
 * @ClassName JwtInterceptorConfig.java
 * @Description TODO
 * @createTime 2022年04月27日 20:10:00
 */
@Configuration
public class JwtInterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //默认拦截所有路径
        registry.addInterceptor(authenticationInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/swagger-ui/**")
                .excludePathPatterns("/swagger-resources/**")
                .excludePathPatterns("/v3/api-docs")
                .excludePathPatterns("/doc.html");
    }
    @Bean
    public JwtAuthenticationInterceptor authenticationInterceptor() {
        return new JwtAuthenticationInterceptor();
    }
}

