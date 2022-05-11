package com.xinxin.config.exception;

import com.xinxin.common.Result;
import com.xinxin.common.excepiton.AdminUserException;
import com.xinxin.response.ResultEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author smile
 * @ClassName AdminUserExcepitonHandler.java
 * @Description TODO
 * @createTime 2022年05月11日 09:36:00
 */
@RestControllerAdvice
public class AdminUserExceptionHandler {

    @ExceptionHandler(value = AdminUserException.checkException.class)
    public Result<String> adminUserPasswordCheckError(Exception e){
        return Result.error(ResultEnum.REJECT.getCode(),e.getMessage());
    }
}
