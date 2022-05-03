package com.xinxin.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author smile
 * @ClassName RegisterUser.java
 * @Description 用户注册表单
 * @createTime 2022年05月03日 20:24:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUser {
    // 用户名
    private String userName;
    // 密码
    private String password;
    // 确认密码
    private String affirmPassword;
}
