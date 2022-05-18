package com.xinxin.utils;

import com.xinxin.bean.sql.User;
import com.xinxin.bean.vo.LoginUser;
import com.xinxin.common.excepiton.UserExcepiton;
import com.xinxin.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author smile
 * @ClassName UserUtils.java
 * @Description TODO
 * @createTime 2022年04月27日 19:52:00
 */
@Component
@Slf4j
public class UserUtils {
    @Autowired
    UserMapper userMapper;

    // T是前端数据，E是数据库数据
    public static boolean checkUser(LoginUser loginUser, User user){
        return user != null && loginUser.getUserName().equals(user.getUserName()) && loginUser.getPassword().equals(user.getPassword());
    }

    // 检查是否是黑名单用户
    public void checkBlackUser(int uid) throws UserExcepiton.UserBaned, UserExcepiton.UserStopMessage {
        Integer result = userMapper.checkBlackUser(uid);
        if(result == null)return;
        if(result.equals(4000)){
            log.info("uid{}用户已被封号",uid);
            // 说明被封号了
            throw new UserExcepiton.UserBaned("");
        }else if(result.equals(4001)){
            // 被禁言了
            log.info("uid{}用户已被禁言",uid);
            throw new UserExcepiton.UserStopMessage("");
        }
    }
}
