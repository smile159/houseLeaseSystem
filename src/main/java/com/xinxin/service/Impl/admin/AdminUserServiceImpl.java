package com.xinxin.service.Impl.admin;

import com.xinxin.bean.admin.AdminLoginUser;
import com.xinxin.bean.admin.AdminUser;
import com.xinxin.common.excepiton.AdminUserException;
import com.xinxin.mapper.admin.AdminUserMapper;
import com.xinxin.service.admin.AdminUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author smile
 * @ClassName AdminUserServiceImpl.java
 * @Description TODO
 * @createTime 2022年05月11日 09:31:00
 */
@Service
@Slf4j
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    AdminUserMapper adminUserMapper;

    @Override
    public void checkAdminUser(AdminLoginUser adminLoginUser) throws AdminUserException.checkException {
        // 根据账号获取用户数据
        AdminUser adminUser = adminUserMapper.getAdminUserByAccount(adminLoginUser.getAccount());
        if(!adminUser.getPassword().equals(adminLoginUser.getPassword())){
            throw new AdminUserException.checkException("账号或密码错误，请重试");
        }
        log.info("后台用户校验成功");
    }
}
