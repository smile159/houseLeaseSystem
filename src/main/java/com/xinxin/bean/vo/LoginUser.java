package com.xinxin.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author smile
 * @ClassName LoginUser.java
 * @Description 登录所需参数对象
 * @createTime 2022年04月27日 16:53:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUser {
    private String userName;
    private String password;
}
