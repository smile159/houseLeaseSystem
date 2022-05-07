package com.xinxin.bean.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author smile
 * @ClassName ViewUser.java
 * @Description 给前端用的对象
 * @createTime 2022年05月03日 20:37:00
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ViewUser {
    /**
     * 用户唯一标识
     */
    private Integer uid;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户身份
     */
    private Integer identity;

    /**
     * 账号状态
     */
    private Integer status;
}
