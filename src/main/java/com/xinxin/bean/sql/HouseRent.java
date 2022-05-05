package com.xinxin.bean.sql;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author smile
 * @ClassName HouseRent.java
 * @Description TODO
 * @createTime 2022年05月04日 10:02:00
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HouseRent {
    /*
    * 出租信息唯一标识
    * */
    private Integer rid;

    /**
     * 出租的房屋id
     */
    private Integer hid;

    /**
     * 出租标题
     */
    private String rentTitle;

    /**
     * 出租的详细内容
     */
    private String rentContent;

    /**
     * 出租年份
     */
    private Integer year;

    /**
     * 出租月份
     */
    private Integer month;

    /**
     * 出租天数
     */
    private Integer day;

    /**
     * 发布日期
     */
    private Date createTime;

    /**
     * 最后更新日期
     */
    private Date updateTime;

    /**
     * 联系人
     */
    private String contactName;

    /**
     * 联系电话
     */
    private String contactPhone;

    /**
     * 当前出租状态:未出租、已出租、隐藏
     */
    private Integer houseStatus;

    // 多对一
    private House house;
}
