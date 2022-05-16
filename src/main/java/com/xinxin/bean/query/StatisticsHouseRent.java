package com.xinxin.bean.query;

import lombok.Data;

/**
 * @author smile
 * @ClassName StatisticsHouseRent.java
 * @Description TODO
 * @createTime 2022年05月16日 21:12:00
 */
@Data
public class StatisticsHouseRent {
    /*
    * 房屋名称
    * */
    private String  houseName;
    /*
    * 浏览次数
    * */
    private Integer glanceCount;
}
