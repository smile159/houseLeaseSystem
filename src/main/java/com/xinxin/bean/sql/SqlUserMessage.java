package com.xinxin.bean.sql;

import lombok.Data;

/**
 * @author smile
 * @ClassName SqlUserMessage.java
 * @Description TODO
 * @createTime 2022年05月09日 15:23:00
 */
@Data
public class SqlUserMessage {
    /*
     * 留言的唯一表示
     * */
    private Integer mid;
    /*
     * 用户唯一标识
     * */
    private Integer uid;
    /*
     * 出租的唯一id
     * */
    private Integer rid;
    /*
     * 留言内容
     * */
    private String message;
    /*
     * 留言时间
     * */
    private String createTime;
}
