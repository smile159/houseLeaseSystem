package com.xinxin.service.Impl;

import com.xinxin.bean.dto.ViewUser;
import com.xinxin.bean.sql.User;
import com.xinxin.bean.vo.EditUserForm;
import com.xinxin.bean.vo.RegisterUser;
import com.xinxin.mapper.UserMapper;
import com.xinxin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


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

    @Override
    public HashMap<String,Object> getUserByPaging(int pageSize, int pageNum) {
        // 计算偏移
        int offset = (pageNum -1) * pageSize;
        // 分页的用户数据
        List<User> userByPaging = userMapper.getUserByPaging(offset, pageSize);
        // 所有用户数量
        int count = userMapper.queryAllUserCount();
        HashMap<String,Object> result = new HashMap<>();
        result.put("result",userByPaging);
        result.put("total",count);
        return result;
    }

    @Override
    public boolean checkUserIsBan(int uid) {
        int result = userMapper.checkBlackUser(uid);
        return result>0;
    }

    @Override
    public int deleteUser(int uid) {
        return userMapper.deleteUserByUid(uid);
    }

    @Override
    public int editUser(EditUserForm editUserForm) {
        return userMapper.editUserByUid(editUserForm);
    }

    @Override
    public int relieveUser(int uid) {
        // 使黑名单无效
        int result = userMapper.relieveUser(uid);
        if(result>0){
            // 修改账号状态
            return userMapper.updateUserStatus(uid,1);
        }
        return 0;
    }

}
