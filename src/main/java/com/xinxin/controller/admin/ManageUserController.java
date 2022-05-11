package com.xinxin.controller.admin;

import com.xinxin.bean.sql.User;
import com.xinxin.common.Result;
import com.xinxin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author smile
 * @ClassName ManageUserController.java
 * @Description 后台用户管理
 * @createTime 2022年05月11日 10:03:00
 */
@RestController
public class ManageUserController {
    @Autowired
    UserService userService;

    @GetMapping("/adminGetUser")
    public Result<List<User>> getUser(int pageSize, int pageNum){
        return Result.success(userService.getUserByPaging(pageSize,pageNum));
    }
}
