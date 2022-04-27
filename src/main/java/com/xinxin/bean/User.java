package com.xinxin.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 
 * @TableName user
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /**
     * 用户唯一标识
     */
    private Integer uid;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户身份
     */
    private Integer identity;

    /**
     * 账号状态
     */
    private Integer status;

    /**
     * 账号token
     */
    private String token;
}