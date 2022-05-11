package com.xinxin.admin;

import com.xinxin.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author smile
 * @ClassName test.java
 * @Description TODO
 * @createTime 2022年05月11日 16:56:00
 */
@SpringBootTest
public class test {
    @Autowired
    UserMapper userMapper;

    @Test
    public void test01(){
        //Integer i = userMapper.checkBlackUser(1);
        Integer i = userMapper.checkBlackUser(2);
        System.out.println(i);
    }
}
