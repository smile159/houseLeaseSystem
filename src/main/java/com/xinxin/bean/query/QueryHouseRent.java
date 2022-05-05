package com.xinxin.bean.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author smile
 * @ClassName QueryHouseRent.java
 * @Description 查询租房信息的参数对象
 * @createTime 2022年05月04日 15:49:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryHouseRent {
    // 每页的条数
    private String pageSize;
    // 查询的页数
    private String pageNum;
}
