package com.xinxin.service.Impl;

import com.xinxin.bean.User;
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
}
