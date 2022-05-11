package com.xinxin.controller.admin;

import com.xinxin.bean.admin.vo.BanUser;
import com.xinxin.bean.vo.EditUserForm;
import com.xinxin.common.Result;
import com.xinxin.service.UserService;
import com.xinxin.service.admin.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @author smile
 * @ClassName ManageUserController.java
 * @Description 后台用户管理
 * @createTime 2022年05月11日 10:03:00
 */
@RestController
@RequestMapping("/admin")
public class ManageUserController {
    @Autowired
    UserService userService;
    @Autowired
    AdminUserService adminUserService;

    @GetMapping("/getUser")
    public Result<HashMap<String, Object>> getUser(int pageSize, int pageNum) throws InterruptedException {
        return Result.success(userService.getUserByPaging(pageSize, pageNum));
    }

    /*
     * 用户封禁
     * */
    @PostMapping("/banUser")
    public Result<String> banUser(@RequestBody BanUser banUser) {
        return adminUserService.adminBanUser(banUser)>0?Result.success("操作成功"):Result.error("操作失败");
    }

    /*
    * 用户删除
    * */
    @GetMapping("/deleteUser")
    public Result<String> deleteUser(int uid){
        return userService.deleteUser(uid)>0?Result.success("删除成功"):Result.error("删除失败");
    }

    /*
    * 用户编辑
    * */
    @PostMapping("/editUser")
    public Result<String> editUser(@RequestBody EditUserForm editUserForm){
        return userService.editUser(editUserForm)>0?Result.success("编辑成功"):Result.error("编辑失败");
    }

    /*
    * 解禁
    * */
    @GetMapping("/relieveUser")
    public Result<String> relieveUser(int uid){
        return userService.relieveUser(uid)>0?Result.success("操作成功"):Result.error("操作失败");
    }
}
