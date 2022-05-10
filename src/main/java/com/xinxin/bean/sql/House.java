package com.xinxin.bean.sql;

import lombok.Data;

/**
 * @author smile
 * @ClassName House.java
 * @Description TODO
 * @createTime 2022年05月04日 16:30:00
 */
@Data
public class House {
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
}
