package com.xinxin.common.excepiton;

import com.xinxin.common.BaseExcepiton;

/**
 * @author smile
 * @ClassName UserExcepiton.java
 * @Description 用户相关的自定义异常
 * @createTime 2022年05月02日 21:19:00
 */
public class UserExcepiton {

    // 用户没有token
    public static class UserNoToken extends BaseExcepiton{
        public UserNoToken(String message) {
            super(message);
        }
    }

    // 用户不存在
    public static class UserInexistence extends BaseExcepiton{
        public UserInexistence(String message) {
            super(message);
        }
    }
    // 用户token过期
    public static class UserTokenExpired extends BaseExcepiton {
        public UserTokenExpired(String message) {
            super(message);
        }
    }
    // 用户封号
    public static class UserBaned extends BaseExcepiton {
        public UserBaned(String message) {
            super(message);
        }
    }
    //禁止发言
    public static class UserStopMessage extends BaseExcepiton {
        public UserStopMessage(String message) {
            super(message);
        }
    }


}
