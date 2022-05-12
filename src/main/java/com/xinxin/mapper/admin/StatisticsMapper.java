package com.xinxin.mapper.admin;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author smile
 * @ClassName StatisticsMapper.java
 * @Description TODO
 * @createTime 2022年05月12日 21:35:00
 */
@Mapper
public interface StatisticsMapper {

    @Select("select count(*) from user")
    public int queryUserCount();

    @Select("select count(*) from house_rent")
    public int queryHouseRentCount();

    @Select("select count(*) from house")
    public int queryHouseCount();
}
