package com.xinxin.mapper;

import com.xinxin.bean.admin.dto.ViewManageHouse;
import com.xinxin.bean.query.StatisticsHouseRent;
import com.xinxin.bean.query.StatisticsUser;
import com.xinxin.bean.sql.House;
import com.xinxin.bean.vo.CreateHouse;
import com.xinxin.bean.vo.UpdateHouse;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author smile
 * @ClassName HouseMapper.java
 * @Description 房屋相关的
 * @createTime 2022年05月04日 11:39:00
 */
@Mapper
public interface HouseMapper {

    public House getHouseByHId(@Param("hid") int hid);

    /*
    * 根据用户id获取所有的房屋
    * */

    @Select("select * from house where uid=#{uid}")
    public List<House> getAllHouseByUid(@Param("uid") int uid);

    /*
    * 根据用户id获取用户名下的所有房屋（分页）
    * */
    @Select("select * from house left join house_rent hr on house.hid = hr.hid limit #{offset},#{pageSize}")
    public List<ViewManageHouse> getAllHouseByUidPaging(@Param("offset") int offset, @Param("pageSize") int pageSize);

    /*
    * 添加房屋
    * 实体类和单独参数放一起会导致解析不了实体类的属性名
    * */
    public int addNewHouse(CreateHouse createHouse);

    /*
    * 删除房屋
    * */
    @Delete("delete from house where uid=#{uid} and hid=#{hid}")
    public int deleteHouseByHid(@Param("uid") int uid,@Param("hid") Integer  hid);


    /*
    * 更新房屋信息
    * */

    @Update("update  house set house_name=#{houseName}, type=#{type}, city=#{city}, address=#{address}, area=#{area}, floor=#{floor}, max_floor=#{maxFloor}, direction=#{direction} where hid=#{hid} and uid=#{uid}")
    public int  updateHouseByHidAndUid(UpdateHouse updateHouse);

    /*
    * 获取某用户的房屋数量
    * */
    @Select("select count(*) from house where uid=#{uid}")
    public int queryUserHouse(int uid);


    /*
    * 根据hid获取rid
    * */
    @Select("select rid from house_rent where hid=#{hid}")
    public int getRidByHid(@Param("hid") int hid);

    /*
    * 获取房屋数量
    * */
    @Select("select count(*) from house")
    public int queryHouseCount();

    @Select("select allow_delete from house_rent where hid=#{hid}")
    public int queryHouseAllowDeleteBiHid(@Param("hid") int hid);


    @Delete("delete from house where hid=#{hid}")
    public int deleteUserHouse(@Param("hid") int hid);

    @Select("select user.user_name,sum(h.glance_count) as count from user left join house h on user.uid = h.uid group by user.uid having sum(h.glance_count)")
    public List<StatisticsUser> queryUserGlance();

    @Select("select h.house_name,glance_count from house h where h.glance_count>0")
    public List<StatisticsHouseRent> queryHouseRentGlance();
}
