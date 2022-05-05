package com.xinxin.bean.sql;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author smile
 * @ClassName HouseTag.java
 * @Description TODO
 * @createTime 2022年05月04日 18:02:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseTag {
    private Integer hTid;
    /*
    * tag名
    * */
    private String name;

    /*
    * tag值
    * */
    private String value;
}
