package com.xinxin.mapper;

import com.xinxin.bean.sql.HouseTag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author smile
 * @ClassName HouseTagMapper.java
 * @Description TODO
 * @createTime 2022年05月04日 18:04:00
 */
@Mapper
public interface HouseTagMapper {
    // 根据hid获取tag
    @Select("select * from house_tag where hid=#{hid}")
    public List<HouseTag> getHouseTagByHid(@Param("hid") Integer hid);

    // 获取前两个
    public List<HouseTag> getHouseTagByHidAndTwo(@Param("hid") Integer hid);
}
