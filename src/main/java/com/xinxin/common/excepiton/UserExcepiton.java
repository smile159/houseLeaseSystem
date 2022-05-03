package com.xinxin.common.excepiton;

import com.xinxin.common.BaseExcepiton;

/**
 * @author smile
 * @ClassName UserExcepiton.java
 * @Description 用户相关的自定义异常
 * @createTime 2022年05月02日 21:19:00
 */
public class UserExcepiton {

    public static class UserNoToken extends BaseExcepiton{
        public UserNoToken(String message) {
            super(message);
        }
    }

    public static class UserInexistence extends BaseExcepiton{
        public UserInexistence(String message) {
            super(message);
        }
    }
}
