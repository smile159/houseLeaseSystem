package com.xinxin.bean.dto;

import lombok.Data;

/**
 * @author smile
 * @ClassName ViewHouseDetail.java
 * @Description TODO
 * @createTime 2022年05月08日 21:01:00
 */
@Data
public class ViewHouseDetail {
    /*
    * 房屋id
    * */
    private Integer hid;
    /*
     * 房屋类型
     * */
    private String type;
    /*
     * 所在城市
     * */
    private String city;
    /*
     * 具体地址
     * */
    private String address;
    /*
     * 房屋面积
     * */
    private Integer area;
    /*
     * 所在楼层
     * */
    private Integer floor;
    /*
     * 最大楼层
     * */
    private Integer maxFloor;
    /*
    * 房屋朝向
    * */
    private String direction;
    /*
    * 出租标题
    * */
    private String rentTitle;
    /*
    *出租具体内容，备注
    * */
    private String rentContent;
    /*
    * 出租月份
    * */
    private Integer month;
    /*
    * 月租金额
    * */
    private Integer monthMoney;
    /*
    * 联系人名
    * */
    private String contactName;
    /*
    * 联系电话
    * */
    private String contactPhone;
    /*
    * 房屋状态
    * */
    private Integer houseStatus;
    /*
    * 创建时间
    * */
    private String createTime;
    /*
    * 更新时间
    * */
    private String updateTime;
}
