package com.xinxin.service.admin;

import com.xinxin.bean.admin.AdminLoginUser;
import com.xinxin.bean.admin.dto.ViewAdminUser;
import com.xinxin.bean.admin.vo.BanUser;
import com.xinxin.common.excepiton.AdminUserException;

/**
 * @author smile
 * @ClassName AdminUserService.java
 * @Description TODO
 * @createTime 2022年05月11日 09:29:00
 */
public interface AdminUserService {

    /*检查管理员账号*/
    public ViewAdminUser checkAdminUser(AdminLoginUser adminLoginUser) throws AdminUserException.checkException;

    /*
    * 封禁用户
    * */

    public int adminBanUser(BanUser banUser);
}
