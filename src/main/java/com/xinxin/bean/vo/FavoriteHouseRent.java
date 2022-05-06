package com.xinxin.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author smile
 * @ClassName FavoriteHouseRent.java
 * @Description TODO
 * @createTime 2022年05月06日 13:48:00
 */
@Data
public class FavoriteHouseRent {
    /*
    * fid
    * */
    private Integer fid;
    /*
    * 用户id
    * */
    private Integer uid;
    /*
    * 出租信息的id
    * */
    private Integer rid;
}
