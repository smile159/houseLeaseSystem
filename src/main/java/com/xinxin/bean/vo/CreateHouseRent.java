package com.xinxin.bean.vo;

import com.xinxin.bean.sql.HouseTag;
import lombok.Data;

import java.util.List;

/**
 * @author smile
 * @ClassName CreateHouseRent.java
 * @Description TODO
 * @createTime 2022年05月17日 10:37:00
 */
@Data
public class CreateHouseRent {
    /*
     * 房屋的关联id
     * */
    private Integer selectHouse;

    /*
    * 租客id
    * */
    private Integer customUid;

    /**
     * 出租标题
     */
    private String rentTitle;

    /*
    * 出租具体内容
    * */
    private String rentContent;

    /*
    * 出租月份
    * */
    private Integer month;

    /*
     * 月租
     * */
    private Integer monthMoney;

    /*
     * 房屋状态
     * */
    private Integer houseStatus;

    /*
    * 联系人姓名
    * */
    private String contactName;

    /*
    * 联系人电话
    * */
    private String contactPhone;

    /*
    * 创建时间
    * */
    private String createTime;
    /*
    * 更新时间
    * */
    private String updateTime;

    /*
    * 自己隐藏
    * */
    private Integer allowHidden;

    /*
    * 是否允许删除
    * */
    private Integer allowDelete;
}
