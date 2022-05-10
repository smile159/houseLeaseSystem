package com.xinxin.mapper;

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

}
