package com.xinxin.mapper;

import com.xinxin.bean.dto.ViewHouseRent;
import com.xinxin.bean.sql.House;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author smile
 * @ClassName HouseMapper.java
 * @Description 房屋相关的
 * @createTime 2022年05月04日 11:39:00
 */
@Mapper
public interface HouseMapper {
    public House getHouseById(@Param("hid") int hid);
}
