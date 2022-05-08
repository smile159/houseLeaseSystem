package com.xinxin.mapper;

import com.xinxin.bean.dto.ViewDetailHouseRent;
import com.xinxin.bean.dto.ViewHouseDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author smile
 * @ClassName DetailMapper.java
 * @Description TODO
 * @createTime 2022年05月08日 21:00:00
 */
@Mapper
public interface DetailMapper {

    // 联表查询，house_rent和house的所有数据
    public ViewHouseDetail getAllDataByHouseRentRid(@Param("rid") int rid);
}
