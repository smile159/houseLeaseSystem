package com.xinxin;

import com.xinxin.bean.sql.User;
import com.xinxin.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HouseLeaseSystemApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> allUser = userMapper.getAllUser();
        System.out.println(allUser);
    }

}
