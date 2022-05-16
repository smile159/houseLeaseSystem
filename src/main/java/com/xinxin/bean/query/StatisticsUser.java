package com.xinxin.bean.query;

import lombok.Data;

/**
 * @author smile
 * @ClassName StatisticsUser.java
 * @Description TODO
 * @createTime 2022年05月16日 21:13:00
 */
@Data
public class StatisticsUser {
    /*
    * 用户名
    * */
    private String userName;
    /*
    * 浏览次数
    * */
    private Integer count;
}
