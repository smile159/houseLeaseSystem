package com.xinxin.service.Impl;

import com.xinxin.bean.dto.ViewUser;
import com.xinxin.bean.sql.User;
import com.xinxin.bean.vo.RegisterUser;
import com.xinxin.mapper.UserMapper;
import com.xinxin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author smile
 * @ClassName UserService.java
 * @Description TODO
 * @createTime 2022年04月27日 14:20:00
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserByName(String userName) {
        log.info("用户名为：{}",userName);
        return userMapper.getUserByName(userName);
    }

    @Override
    public User getUserById(String uid) {
        return userMapper.getUserById(uid);
    }

    @Override
    public boolean registerUser(RegisterUser registerUser) {
        //User newUser = new User();
        //BeanUtils.copyProperties(registerUser,newUser);
        User newUser = User.builder()
                .userName(registerUser.getUserName())
                .password(registerUser.getPassword())
                .identity(3)
                .status(1)
                .build();
        System.out.println("newUser = "+newUser);
        int insertResult = userMapper.insertUser(newUser);
        return insertResult > 0;
    }
}
