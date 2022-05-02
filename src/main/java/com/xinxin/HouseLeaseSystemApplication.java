package com.xinxin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class HouseLeaseSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HouseLeaseSystemApplication.class, args);
    }

}
