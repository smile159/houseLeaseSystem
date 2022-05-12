package com.xinxin.bean.admin.dto;

import lombok.Data;

/**
 * @author smile
 * @ClassName ViewManageHouse.java
 * @Description TODO
 * @createTime 2022年05月12日 16:50:00
 */
@Data
public class ViewManageHouse {

    /**
     * 房屋唯一标识
     */
    private Integer hid;

    /**
     * 房东id
     */
    private Integer uid;

    /**
     * 房屋名称、类似备注
     */
    private String houseName;

    /**
     * 房屋类型
     */
    private String type;

    /**
     * 所在城市
     */
    private String city;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 房屋面积
     */
    private Integer area;

    /**
     * 房屋所在楼层
     */
    private Integer floor;

    /**
     * 房屋最大层数
     */
    private Integer maxFloor;

    /**
     * 朝向
     */
    private String direction;
    /*
    * 租赁情况
    * */
    private Integer houseStatus;
    /*
    * 是否隐藏 1表示隐藏，0表示不隐藏
    * */
    private Integer allowHidden;
    /*
    * 是否允许删除 1表示允许删除，0表示不允许删除
    * */
    private Integer allowDelete;
}
