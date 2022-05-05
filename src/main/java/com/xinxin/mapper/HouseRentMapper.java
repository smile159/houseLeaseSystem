package com.xinxin.mapper;

import com.xinxin.bean.dto.ViewHouseRent;
import com.xinxin.bean.sql.HouseRent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author smile
 * @ClassName HouseRentMapper.java
 * @Description 房屋出租相关的
 * @createTime 2022年05月04日 16:46:00
 */
@Mapper
public interface HouseRentMapper {
    // 分页查询
    public List<ViewHouseRent> getRecommendHouseRent();
}
