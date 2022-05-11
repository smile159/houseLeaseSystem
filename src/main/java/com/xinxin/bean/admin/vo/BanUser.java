package com.xinxin.bean.admin.vo;

import lombok.Data;

/**
 * @author smile
 * @ClassName BanUser.java
 * @Description TODO
 * @createTime 2022年05月11日 15:03:00
 */
@Data
public class BanUser {
    /*
    * 操作人的id
    * */
    private Integer operationUid;
    /*
    * 被封禁的用户
    * */
    private Integer banId;
    /*
    * 封禁措施
    * */
    private Integer measure;
    /*
    * 封禁原因
    * */
    private String reason;
    /*
    * 操作时间
    * */
    private String createTime;
    /*
    * 封禁开始时间
    * */
    private String startTime;
    /*
    * 封禁结束时间
    * */
    private String endTime;

    /*
    * 状态 0无效，1有效
    * */
    private Integer status;
}
