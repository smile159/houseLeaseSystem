package com.xinxin.service;

import com.xinxin.bean.sql.House;
import com.xinxin.bean.vo.CreateHouse;
import com.xinxin.bean.vo.UpdateHouse;

import java.util.List;

/**
 * @author smile
 * @ClassName HouseService.java
 * @Description TODO
 * @createTime 2022年05月04日 11:39:00
 */
public interface HouseService {
    /*
    * 获取所有的房屋
    * */
    public List<House> getAllHouse(int uid);

    /*
    * 添加房屋
    * */
    public int insertHouse(CreateHouse createHouse);

    /*
    * 删除房屋
    * */

    public int deleteHouse(int uid,Integer hid);

    /*
    * 修改房屋
    * */
    public int updateHouse(UpdateHouse updateHouse);

    /*
    * 根据hid获取房屋
    * */

    public House getHouse(int hid);
}
