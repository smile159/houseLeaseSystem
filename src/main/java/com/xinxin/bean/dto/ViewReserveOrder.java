package com.xinxin.bean.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author smile
 * @ClassName ViewReserveOrder.java
 * @Description TODO
 * @createTime 2022年05月09日 09:23:00
 */
@Data
@Builder
public class ViewReserveOrder {
    /*
    * 订单的唯一id
    * */
    private Integer rOid;

    /*
    * 房屋出租id
    * */
    private Integer rid;

    /*
    * 入住日期
    * */
    private String  startTime;

    /*
    * 退租日期
    * */

    private String endTime;

    /*
    * 预订日期
    * */
    private String reserveTime;

}
