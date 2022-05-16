package com.xinxin.bean.query;

import lombok.Data;

/**
 * @author smile
 * @ClassName ConditionsSearch.java
 * @Description TODO
 * @createTime 2022年05月16日 22:11:00
 */
@Data
public class ConditionsSearch {
    /*
    * 搜索的城市
    * */
    private String selectCityName;
    /*
    * 搜索的街道，模糊搜索
    * */
    private String address;
    /*
    * 起始价格
    * */
    private Integer priceStart;
    /*
    * 结束价格
    * */
    private Integer priceEnd;
}
