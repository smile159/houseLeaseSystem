package com.xinxin.bean.vo;

import lombok.Builder;
import lombok.Data;

/**
 * @author smile
 * @ClassName ReserveOrder.java
 * @Description TODO
 * @createTime 2022年05月09日 09:25:00
 */
@Data
@Builder
public class ReserveOrder {
    /*
     * rid
     * */
    private Integer rid;

    /*
     * 开始日期
     * */
    private String startTime;
    /*
     * 结束日期
     * */
    private String endTime;
    /*
     * 预订用户
     * */
    private String userName;

    /*
    * 创建时间
    * */
    private String createTime;


}
