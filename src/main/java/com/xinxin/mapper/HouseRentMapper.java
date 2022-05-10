package com.xinxin.mapper;

import com.xinxin.bean.dto.ViewDetailHouseRent;
import com.xinxin.bean.dto.ViewHouseRent;
import com.xinxin.bean.sql.Favorite;
import com.xinxin.bean.sql.HouseRent;
import com.xinxin.custom.annotation.PassToken;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author smile
 * @ClassName HouseRentMapper.java
 * @Description 房屋出租相关的
 * @createTime 2022年05月04日 16:46:00
 */
@Mapper
public interface HouseRentMapper {
    // 推荐出租信息
    public List<ViewHouseRent> getRecommendHouseRent();
    // 分页查询
    public List<ViewHouseRent> getHouseRentByPaging(@Param("offset") Integer offset,@Param("pageSize") Integer pageSize);
    // 根据rid获取fid
    public Integer getFavoriteFidByRid(@Param("rid") int rid);
    // 根据uid查询租赁信息
    public List<ViewHouseRent> getMyHouseRentById(@Param("uid") int uid,@Param("type") int type);
    // 根据custom_uid查询租赁信息
    public List<ViewHouseRent> getMyHouseRentByCustomId(@Param("cid") int cid);
    // 根据rid查询所有数据
    public ViewDetailHouseRent getMyHouseRentDetail(@Param("rid") int rid);
    // 修改出租信息
    public int updateMyHouseRent(ViewDetailHouseRent viewDetailHouseRent);
    // 下架出租信息
    @Update("update house_rent set house_status=#{houseStatus} where rid=#{rid}")
    public int updateHouseStatus(@Param("rid") int rid,@Param("houseStatus")int houseStatus);
    // 删除发布信息
    @Delete("delete from house_rent where rid=#{rid}")
    public int deleteHouseRent(@Param("rid") int rid);
}
