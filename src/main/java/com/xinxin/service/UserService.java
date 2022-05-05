package com.xinxin.service;

import com.xinxin.bean.sql.User;
import com.xinxin.bean.vo.RegisterUser;
import org.apache.ibatis.annotations.Param;

/**
 * @author smile
 * @ClassName UserService.java
 * @Description TODO
 * @createTime 2022年04月27日 14:19:00
 */
public interface UserService {
    public User getUserByName(@Param("userName") String userName);

    public User getUserById(@Param("uid") String uid);

    public boolean registerUser(@Param("user") RegisterUser user);
}
