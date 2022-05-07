package com.xinxin.controller;

import com.xinxin.custom.annotation.PassToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author smile
 * @ClassName HelloController.java
 * @Description TODO
 * @createTime 2022年04月27日 14:06:00
 */
@RestController
public class HelloController {


    @GetMapping("/")
    public String index() {
        return "Hello SpringBoot + Vue !!!";
    }

    @GetMapping("/testToken")
    public String testToken() {
        return "测试token的";
    }

    @PassToken
    @PostMapping("/testData")
    public HashMap<String, Object> testData(int id) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("id",id);
        return result;
    }
}
