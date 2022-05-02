package com.xinxin.config.exception;

import com.xinxin.common.Result;
import com.xinxin.common.excepiton.UserExcepiton;
import com.xinxin.response.ResultEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author smile
 * @ClassName UserExcepiton.java
 * @Description 用户相关的异常处理
 * @createTime 2022年05月02日 21:07:00
 */

@RestControllerAdvice
public class UserExcepitonHandler {

    @ExceptionHandler(value = UserExcepiton.UserNoToken.class)
    public Result<String> userTokenException(Exception e) {
        return Result.error(ResultEnum.ERROR.getCode(),ResultEnum.ERROR.getMsg());
    }
}
