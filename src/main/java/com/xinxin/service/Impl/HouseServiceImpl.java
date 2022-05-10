package com.xinxin.service.Impl;

import com.xinxin.bean.sql.House;
import com.xinxin.bean.vo.CreateHouse;
import com.xinxin.bean.vo.UpdateHouse;
import com.xinxin.mapper.HouseMapper;
import com.xinxin.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<House> getAllHouse(int uid) {
        return houseMapper.getAllHouseByUid(uid);
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
}
