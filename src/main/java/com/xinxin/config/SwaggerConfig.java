package com.xinxin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author smile
 * @ClassName SwaggerConfig.java
 * @Description TODO
 * @createTime 2022年05月02日 20:38:00
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.OAS_30).apiInfo(apiInfo())
                .enable(true).select()
                .apis(RequestHandlerSelectors.basePackage("com.xinxin"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/");
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("房屋出租系统API")
                .description("springboot | swagger")
                // 作者信息
                .contact(new Contact("smile", "http://smileya.cn", "666"))
                .version("1.0.0")
                .build();
    }
}
