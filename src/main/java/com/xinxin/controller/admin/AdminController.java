package com.xinxin.controller.admin;

import com.xinxin.bean.admin.AdminLoginUser;
import com.xinxin.bean.admin.AdminUser;
import com.xinxin.common.Result;
import com.xinxin.common.excepiton.AdminUserException;
import com.xinxin.custom.annotation.PassToken;
import com.xinxin.service.admin.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author smile
 * @ClassName AdminController.java
 * @Description 后台登录
 * @createTime 2022年05月10日 22:52:00
 */
@RestController
public class AdminController {
    @Autowired
    AdminUserService adminUserService;

    @PostMapping("/adminLogin")
    public Result<String> login(@RequestBody AdminLoginUser adminLoginUser) throws AdminUserException.checkException, InterruptedException {
        System.out.println("adminLoginUser = "+adminLoginUser);
        adminUserService.checkAdminUser(adminLoginUser);
        // 模拟请求过多
        Thread.sleep(5000);
        return Result.success("登录成功");
    }
}
