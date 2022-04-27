package com.xinxin.utils;

import com.xinxin.bean.User;
import com.xinxin.bean.vo.LoginUser;

/**
 * @author smile
 * @ClassName UserUtils.java
 * @Description TODO
 * @createTime 2022年04月27日 19:52:00
 */
public class UserUtils {

    // T是前端数据，E是数据库数据
    public static boolean checkUser(LoginUser loginUser, User user){
        return user != null && loginUser.getUserName().equals(user.getUserName()) && loginUser.getPassword().equals(user.getPassword());
    }
}
