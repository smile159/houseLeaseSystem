package com.xinxin.service.Impl.admin;

import com.xinxin.bean.admin.AdminLoginUser;
import com.xinxin.bean.admin.AdminUser;
import com.xinxin.bean.admin.dto.ViewAdminUser;
import com.xinxin.bean.admin.vo.BanUser;
import com.xinxin.common.excepiton.AdminUserException;
import com.xinxin.mapper.UserMapper;
import com.xinxin.mapper.admin.AdminUserMapper;
import com.xinxin.service.admin.AdminUserService;
import com.xinxin.utils.DateTimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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

    @Autowired
    UserMapper userMapper;

    @Override
    public ViewAdminUser checkAdminUser(AdminLoginUser adminLoginUser) throws AdminUserException.checkException {
        // 根据账号获取用户数据
        AdminUser adminUser = adminUserMapper.getAdminUserByAccount(adminLoginUser.getAccount());
        ViewAdminUser viewAdminUser = new ViewAdminUser();
        BeanUtils.copyProperties(adminUser,viewAdminUser);
        if(!adminUser.getPassword().equals(adminLoginUser.getPassword())){
            throw new AdminUserException.checkException("账号或密码错误，请重试");
        }
        log.info("后台用户校验成功");
        return viewAdminUser;
    }

    @Override
    public int adminBanUser(BanUser banUser) {
        // 填充操作的时间
        banUser.setCreateTime(DateTimeUtils.getNowDateTime());
        banUser.setStatus(0);
        // 写入黑名单表
        int result = adminUserMapper.insertUserBlackList(banUser);
        if(result >0) {
            // 修改用户status
            return userMapper.updateUserStatus(banUser.getBanId(),0);
        }
        return 0;
    }
}
