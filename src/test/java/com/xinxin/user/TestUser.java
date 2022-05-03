package com.xinxin.user;

import com.xinxin.bean.vo.RegisterUser;
import com.xinxin.mapper.UserMapper;
import com.xinxin.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author smile
 * @ClassName TestUser.java
 * @Description TODO
 * @createTime 2022年05月03日 22:03:00
 */
@SpringBootTest
public class TestUser {
    @Autowired
    UserService userService;

    @Test
    public void testRegister(){
        RegisterUser registerUser = new RegisterUser();
        registerUser.setUserName("测试注册功能");
        registerUser.setPassword("666666");
        registerUser.setAffirmPassword("666666");
        boolean b = userService.registerUser(registerUser);
        System.out.println("注册状态："+b);
    }
}
