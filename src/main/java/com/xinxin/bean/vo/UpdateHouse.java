package com.xinxin.bean.vo;

import lombok.Data;

/**
 * @author smile
 * @ClassName UpdateHouse.java
 * @Description TODO
 * @createTime 2022年05月10日 10:10:00
 */
@Data
public class UpdateHouse {
    /*
    * 房屋id
    * */
    private Integer hid;
    /*
     * 用户id
     * */
    private Integer uid;
    /*
     *房屋名称
     * */
    private String houseName;
    /*
     * 房屋类型
     * */
    private String type;
    /*
     * 房屋所在城市
     * */
    private String city;
    /*
     * 房屋详细地址
     * */
    private String address;
    /*
     * 房屋面积
     * */
    private Integer area;
    /*
     * 房屋楼层
     * */
    private Integer floor;
    /*
     * 访问最大楼层
     * */
    private Integer maxFloor;
    /*
     * 房屋朝向
     * */
    private String direction;
}
