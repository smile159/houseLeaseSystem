package com.xinxin.common.excepiton;

import com.xinxin.common.BaseExcepiton;
import com.xinxin.common.Result;

/**
 * @author smile
 * @ClassName AdminUserException.java
 * @Description TODO
 * @createTime 2022年05月11日 09:34:00
 */
public class AdminUserException {

    // 管理员密码错误
    public static class checkException extends BaseExcepiton {
        public checkException(String message) {
            super(message);
        }
    }
}
