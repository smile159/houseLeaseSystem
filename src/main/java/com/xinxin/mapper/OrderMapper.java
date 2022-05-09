package com.xinxin.mapper;

import com.xinxin.bean.dto.ViewReserveOrder;
import com.xinxin.bean.vo.ReserveOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

/**
 * @author smile
 * @ClassName OrderMapper.java
 * @Description TODO
 * @createTime 2022年05月09日 09:21:00
 */
@Mapper
public interface OrderMapper {

    @Insert("insert into reserve_order (r_oid, rid, start_time, end_time, create_time, reserve_name) values (null,#{rid},#{startTime},#{endTime},#{createTime},#{userName});")
    public int createReserveOrder(ReserveOrder reserveOrder);



}
