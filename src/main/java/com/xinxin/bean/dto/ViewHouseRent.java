package com.xinxin.bean.dto;

import com.xinxin.bean.sql.House;
import com.xinxin.bean.sql.HouseRent;
import com.xinxin.bean.sql.HouseTag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author smile
 * @ClassName ViewHouseRent.java
 * @Description 给前端传输的对象
 * @createTime 2022年05月04日 11:27:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewHouseRent {
    /*
     * 出租信息唯一标识
     * */
    private Integer rid;

    /**
     * 出租标题
     */
    private String rentTitle;

    /*
    * 月租
    * */
    private Integer monthMoney;

    /*
    * 房屋的详细地址
    * */
    private String address;

    /*
    * 房屋状态
    * */
    private Integer houseStatus;

    /*
    * 收藏
    * */
    private Integer fid;

    /*
    * 标签(取前两个)
    * */
    private List<HouseTag> houseTags;

}
