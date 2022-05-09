package com.xinxin.bean.vo;

import lombok.Builder;
import lombok.Data;

/**
 * @author smile
 * @ClassName SqlUserMessage.java
 * @Description 用户留言
 * @createTime 2022年05月09日 10:21:00
 */
@Data
@Builder
public class UserMessage {
    /*
    * 用户id
    * */
    private Integer uid;
    /*
    * 出租id
    * */
    private Integer rid;
    /*
    * 留言信息
    * */
    private String message;
    /*
    * 留言时间
    * */
    private String createTime;
}
