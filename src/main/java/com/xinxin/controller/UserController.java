package com.xinxin.controller;

import com.xinxin.bean.sql.User;
import com.xinxin.bean.dto.ViewUser;
import com.xinxin.bean.vo.LoginUser;
import com.xinxin.bean.vo.RegisterUser;
import com.xinxin.common.ExpirationTime;
import com.xinxin.common.Result;
import com.xinxin.common.ResultMessage;
import com.xinxin.common.excepiton.UserExcepiton;
import com.xinxin.custom.annotation.PassToken;
import com.xinxin.service.UserService;
import com.xinxin.utils.CookieUtils;
import com.xinxin.utils.JwtUtils;
import com.xinxin.utils.UserUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author smile
 * @ClassName UserController.java
 * @Description 用户相关操作
 * @createTime 2022年04月27日 16:51:00
 */
@RestController
@Api("userController")
@Slf4j
@RequestMapping("house")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserUtils userUtils;

    @PostMapping("/login")
    @PassToken
    @ApiOperation(value = "用户登录")
    public Result<ViewUser> loginUser(@RequestBody @ApiParam(value = "前端请求参数",required = true) LoginUser loginUser,@ApiParam(value = "设置COOKIE") HttpServletResponse response) throws UserExcepiton.UserStopMessage, UserExcepiton.UserBaned {
        System.out.println("收到了登录请求：" + loginUser);
        // 数据库查询用户
        User sqlUser = userService.getUserByName(loginUser.getUserName());
        System.out.println("login = "+sqlUser);
        userUtils.checkBlackUser(sqlUser.getUid());
        // 校验数据是否为空，用户名和密码是否一致
        if (UserUtils.checkUser(loginUser,sqlUser)) {
            // 设置响应头token值，下次请求必须携带
            response.addCookie(CookieUtils.createCookie("token",JwtUtils.createToken(sqlUser), ExpirationTime.SEVENDAYS,true));
            ViewUser viewUser = ViewUser.builder()
                    .uid(sqlUser.getUid())
                    .userName(sqlUser.getUserName())
                    .identity(sqlUser.getIdentity())
                    .status(sqlUser.getStatus())
                    .build();
            log.info("校验通过");
            return Result.success(ResultMessage.LOGINSUCCESS,viewUser);
        } else {
            log.info("校验失败");
            return Result.error("账号或密码错误");
        }
    }


    @PostMapping("/register")
    @PassToken
    @ApiOperation(value = "用户注册")
    public Result<ViewUser> registerUser(@RequestBody RegisterUser registerUser){
        // 先查询用户是否已经存在
        User userByName = userService.getUserByName(registerUser.getUserName());
        if(userByName != null) return Result.error(ResultMessage.UserNUll);
        // 用户不存在，将数据插入到数据库中
        if(userService.registerUser(registerUser)){
            return Result.success(ResultMessage.REGISTERSUCCESS);
        }
        return Result.error(ResultMessage.REGISTERERROR);
    }
}
