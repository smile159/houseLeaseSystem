package com.xinxin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author smile
 * @ClassName HelloController.java
 * @Description TODO
 * @createTime 2022年04月27日 14:06:00
 */
@RestController
public class HelloController {


    @GetMapping("/")
    public String index(){
        return "Hello SpringBoot + Vue !!!";
    }
}
