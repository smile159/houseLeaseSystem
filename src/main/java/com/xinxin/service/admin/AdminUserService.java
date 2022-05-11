package com.xinxin.service.admin;

import com.xinxin.bean.admin.AdminLoginUser;
import com.xinxin.common.excepiton.AdminUserException;

/**
 * @author smile
 * @ClassName AdminUserService.java
 * @Description TODO
 * @createTime 2022年05月11日 09:29:00
 */
public interface AdminUserService {

    /*检查管理员账号*/
    public void checkAdminUser(AdminLoginUser adminLoginUser) throws AdminUserException.checkException;
}
