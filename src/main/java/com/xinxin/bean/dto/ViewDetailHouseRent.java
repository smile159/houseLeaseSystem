package com.xinxin.bean.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author smile
 * @ClassName ViewDetailHouseRent.java
 * @Description TODO
 * @createTime 2022年05月07日 15:13:00
 */
@Data
public class ViewDetailHouseRent {
    /*
     * 出租信息唯一标识
     * */
    private Integer rid;

    /**
     * 出租的房屋id
     */
    private Integer hid;

    /*
    * custom_uid
    * */
    private Integer cid;

    /*
    * 租客姓名
    * */
    private String customName;

    /**
     * 出租标题
     */
    private String rentTitle;

    /**
     * 出租的详细内容
     */
    private String rentContent;

    /**
     * 出租月份
     */
    private Integer month;

    /*
    * 月金额
    * */
    private Integer monthMoney;

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
}
