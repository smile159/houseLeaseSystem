package com.xinxin.bean.dto;

import lombok.Data;

/**
 * @author smile
 * @ClassName ViewHouseSelect.java
 * @Description select选择
 * @createTime 2022年05月17日 09:51:00
 */
@Data
public class ViewHouseSelect {
    /*
    * 房屋的唯一标识
    * */
    private Integer hid;
    /*
    * 房屋的备注
    * */
    private String houseName;
}
