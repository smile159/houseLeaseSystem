package com.xinxin.bean.admin;

import lombok.Data;

/**
 * @author smile
 * @ClassName AdminUser.java
 * @Description TODO
 * @createTime 2022年05月11日 09:07:00
 */
@Data
public class AdminUser {
    /*
    * 账号唯一标识
    * */
    private Integer a_uid;
    /*
    * 账号
    * */
    private String account;
    /*
    * 密码
    * */
    private String password;
    /*
    * 邮箱
    * */
    private String email;
    /*
    * 电话
    * */
    private String phone;
    /*
    * 身份
    * */
    private Integer identity;
    /*
    * 创建时间
    * */
    private String create_time;
    /*
    * 上次活动时间
    * */
    private String active_time;
    /*
    * 账号状态
    * */
    private Integer status;
}
