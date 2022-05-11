package com.xinxin.bean.admin.dto;

import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWarDeployment;

/**
 * @author smile
 * @ClassName ViewAdminUser.java
 * @Description TODO
 * @createTime 2022年05月11日 21:13:00
 */
@Data
public class ViewAdminUser {
    /*
     * 账号唯一标识
     * */
    private Integer aUid;
    /*
     * 账号
     * */
    private String account;
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
    private String createTime;
    /*
     * 上次活动时间
     * */
    private String activeTime;
    /*
     * 账号状态
     * */
    private Integer status;
}
