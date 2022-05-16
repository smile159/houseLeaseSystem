package com.xinxin.service;

import com.xinxin.bean.dto.ViewStatistics;
import com.xinxin.bean.sql.House;
import com.xinxin.bean.vo.CreateHouse;
import com.xinxin.bean.vo.UpdateHouse;

import java.util.HashMap;
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
    * 获取所有的房屋
    * */
    public HashMap<String,Object> getAllHouseByPaging(int pageSize, int pageNum);

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

    /*
    * 禁止房屋租赁信息查询
    * */
    public int disabledQueryHouseRent(int hid);

    /*
    * 取消禁止房屋租赁信息查询
    * */
    public int unDisabledQueryHouseRent(int hid);


    /*
    * 禁止房屋被删除
    * */
    public int disabledHouseDelete(int hid);

    /*
    * 取消禁止房屋被删除
    * */
    public int allowHouseDelete(int hid);
    /*
    * 查询是否允许删除
    * */
    public int queryHouseIsAllowDelete(int hid);

    /*
    * 删除
    * */
    public int adminDeleteUserHouseByHid(int hid);


    /*
    * 获取浏览统计数据
    * */
    public ViewStatistics queryHouseRentAndUserGlance();
}
