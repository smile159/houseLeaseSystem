package com.xinxin.bean.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author smile
 * @ClassName ViewUserMessage.java
 * @Description TODO
 * @createTime 2022年05月09日 14:46:00
 */
@Data
public class ViewUserMessage {
    /*
    * 留言的唯一表示
    * */
    private Integer mid;
    /*
    * 用户名
    * */
    private String userName;
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
    /*
    * 留言状态
    * */
    private Integer read;
}
