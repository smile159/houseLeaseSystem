package com.xinxin.service.Impl;

import com.xinxin.bean.admin.dto.ViewManageHouse;
import com.xinxin.bean.dto.ViewStatistics;
import com.xinxin.bean.sql.House;
import com.xinxin.bean.vo.CreateHouse;
import com.xinxin.bean.vo.UpdateHouse;
import com.xinxin.mapper.HouseMapper;
import com.xinxin.mapper.HouseRentMapper;
import com.xinxin.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author smile
 * @ClassName HouseServiceImpl.java
 * @Description TODO
 * @createTime 2022年05月04日 11:39:00
 */
@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    HouseMapper houseMapper;
    @Autowired
    HouseRentMapper houseRentMapper;

    @Override
    public List<House> getAllHouse(int uid) {
        return houseMapper.getAllHouseByUid(uid);
    }

    @Override
    public HashMap<String,Object> getAllHouseByPaging( int pageSize, int pageNum) {
        int offset = (pageNum - 1) * pageSize;
        // 查询数据
        List<ViewManageHouse> allHouseByUidPaging = houseMapper.getAllHouseByUidPaging( offset, pageSize);
        // 查询条数
        int count = houseMapper.queryHouseCount();
        HashMap<String,Object> result = new HashMap<>();
        result.put("result",allHouseByUidPaging);
        result.put("total",count);
        return result;
    }


    @Override
    public int insertHouse(CreateHouse createHouse) {
        return houseMapper.addNewHouse(createHouse);
    }

    @Override
    public int deleteHouse(int uid,Integer hid) {
        return houseMapper.deleteHouseByHid(uid,hid);
    }

    @Override
    public int updateHouse(UpdateHouse updateHouse) {
        return houseMapper.updateHouseByHidAndUid(updateHouse);
    }

    @Override
    public House getHouse(int hid) {
        return houseMapper.getHouseByHId(hid);
    }

    @Override
    public int disabledQueryHouseRent(int hid) {
        // 根据rid设置状态 1为隐藏
        return houseRentMapper.updateHouseStatus(hid, 1);
    }

    @Override
    public int unDisabledQueryHouseRent(int hid) {
        return houseRentMapper.updateHouseStatus(hid, 0);
    }

    /*
    * 禁止删除
    * */
    @Override
    public int disabledHouseDelete(int hid) {
        return houseRentMapper.updateHouseRentAllowDelete(hid,0);
    }

    @Override
    public int allowHouseDelete(int hid) {
        return houseRentMapper.updateHouseRentAllowDelete(hid,1);
    }

    @Override
    public int queryHouseIsAllowDelete(int hid) {
        return houseMapper.queryHouseAllowDeleteBiHid(hid);
    }

    @Override
    public int adminDeleteUserHouseByHid(int hid) {
        return houseMapper.deleteUserHouse(hid);
    }

    @Override
    public ViewStatistics queryHouseRentAndUserGlance() {
        ViewStatistics viewStatistics = ViewStatistics.builder()
                .houseRentGlance(houseMapper.queryHouseRentGlance())
                .userGlance(houseMapper.queryUserGlance())
                .build();
        return viewStatistics;
    }
}
