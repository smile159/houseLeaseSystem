package com.xinxin.controller;

import com.xinxin.bean.User;
import com.xinxin.bean.vo.LoginUser;
import com.xinxin.common.ExpirationTime;
import com.xinxin.common.Result;
import com.xinxin.common.ResultMessage;
import com.xinxin.custom.annotation.PassToken;
import com.xinxin.service.UserService;
import com.xinxin.utils.CookieUtils;
import com.xinxin.utils.JwtUtils;
import com.xinxin.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * @author smile
 * @ClassName UserController.java
 * @Description 用户相关操作
 * @createTime 2022年04月27日 16:51:00
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    @PassToken
    public Result<User> loginUser(@RequestBody LoginUser loginUser, HttpServletResponse response) {
        System.out.println("收到了登录请求：" + loginUser);
        // 数据库查询用户
        User sqlUser = userService.getUserByName(loginUser.getUserName());
        System.out.println("login = "+sqlUser);
        // 校验数据是否为空，用户名和密码是否一致
        if (UserUtils.checkUser(loginUser,sqlUser)) {
            // 设置响应头token值，下次请求必须携带
            //response.setHeader("token", JwtUtils.createToken(sqlUser));
            response.addCookie(CookieUtils.createCookie("token",JwtUtils.createToken(sqlUser), ExpirationTime.SEVENDAYS,true));
            return Result.sussess(ResultMessage.LOGINSUCCESS,sqlUser);
        } else {
            return Result.error();
        }
    }
}
