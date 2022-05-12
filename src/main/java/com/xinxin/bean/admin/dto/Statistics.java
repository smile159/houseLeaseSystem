package com.xinxin.bean.admin.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author smile
 * @ClassName Statistics.java
 * @Description TODO
 * @createTime 2022年05月12日 21:32:00
 */
@Data
@Builder
public class Statistics {
    /*
    * 用户数量
    * */
    private Integer userCount;
    /*
    * 发布的租赁数量
    * */
    private Integer houseRentCount;
    /*
    * 房屋数量
    * */
    private Integer houseCount;
}
