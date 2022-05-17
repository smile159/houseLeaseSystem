package com.xinxin.mapper;

import com.xinxin.bean.dto.ViewDetailHouseRent;
import com.xinxin.bean.dto.ViewHouseRent;
import com.xinxin.bean.query.ConditionsSearch;
import com.xinxin.bean.sql.Favorite;
import com.xinxin.bean.sql.HouseRent;
import com.xinxin.bean.vo.CreateHouseRent;
import com.xinxin.custom.annotation.PassToken;
import org.apache.ibatis.annotations.*;

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
    /*
     * 条件搜索，动态sql
     * */
    public List<ViewHouseRent> conditionsSearch(ConditionsSearch conditionsSearch);



    /*
    * 修改房屋是否隐藏
    * */
    @Update("update house_rent set allow_hidden=#{allowHidden} where hid=#{hid}")
    public int updateHouseHidden(@Param("hid") int hid,@Param("allowHidden") int allowHidden);

    /*
    * 修改房屋的出租状态，控制是可出租还是已出租
    * */
    @Update("update house_rent set house_status=#{houseStatus} where rid=#{rid}")
    public int updateHouseStatus(@Param("rid") int rid,@Param("houseStatus") int houseStatus);

    // 删除发布信息
    @Delete("delete from house_rent where rid=#{rid}")
    public int deleteHouseRent(@Param("rid") int rid);

    // 更新allowdelete
    @Update("update house_rent set allow_delete=#{allowDelete} where hid=#{hid}")
    public int updateHouseRentAllowDelete(@Param("hid") int hid,@Param("allowDelete") int allowDelete);
    @Select("select allow_delete from house_rent where rid=#{rid}")
    public int queryHouseRentAllowDeleteBiHid(@Param("rid") int rid);

    // 浏览统计增加(租赁信息的房屋上)
    @Update("update house set glance_count=glance_count+1 where hid=#{hid}")
    public int addGlance(@Param("hid") int hid);

    /*
    * 创建发布的租赁
    * */
    @Insert("insert into house_rent (hid, custom_uid, rent_title, rent_content, month, month_money, contact_name, contact_phone, house_status, create_time, update_time, allow_hidden, allow_delete) values (#{selectHouse},#{customUid},#{rentTitle},#{rentContent},#{month},#{monthMoney},#{contactName},#{contactPhone},#{houseStatus},#{createTime},#{updateTime},#{allowHidden},#{allowDelete});")
    public int insertHouseRent(CreateHouseRent createHouseRent);
}
