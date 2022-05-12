package com.xinxin.service.Impl;

import com.xinxin.bean.dto.ViewDetailHouseRent;
import com.xinxin.bean.dto.ViewHouseRent;
import com.xinxin.bean.sql.HouseRent;
import com.xinxin.mapper.HouseMapper;
import com.xinxin.mapper.HouseRentMapper;
import com.xinxin.service.HouseRentService;
import com.xinxin.utils.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.View;
import java.util.List;

/**
 * @author smile
 * @ClassName HouseRentServiceImpl.java
 * @Description TODO
 * @createTime 2022年05月04日 16:48:00
 */
@Service
public class HouseRentServiceImpl implements HouseRentService {
    @Autowired
    HouseRentMapper houseRentMapper;

    @Override
    public List<ViewHouseRent> queryHouseRent(int pageSize, int pageNum) {
        // 计算偏移量
        int offset = (pageNum - 1) * pageSize;
        return houseRentMapper.getHouseRentByPaging(offset, pageSize);
    }

    @Override
    public List<ViewHouseRent> getRecommendHouseRent() {
        return houseRentMapper.getRecommendHouseRent();
    }

    @Override
    public List<ViewHouseRent> getMyHouseRentById(int uid, int type) {
        if (type == 2) {
            return houseRentMapper.getMyHouseRentByCustomId(uid);
        } else {
            return houseRentMapper.getMyHouseRentById(uid, type);
        }
    }

    @Override
    public ViewDetailHouseRent getMyHouseRentDetailData(int rid) {
        return houseRentMapper.getMyHouseRentDetail(rid);
    }

    @Override
    public int updateMyHouseRent(ViewDetailHouseRent viewDetailHouseRent) {
        // 先计算当前时间，更新update_time字段
        viewDetailHouseRent.setUpdateTime(DateTimeUtils.getNowDateTime());
        // 调用接口修改数据
        return houseRentMapper.updateMyHouseRent(viewDetailHouseRent);
    }

    @Override
    public int hiddenMyHouseRent(int rid) {
        return houseRentMapper.updateHouseStatus(rid,1);
    }

    @Override
    public int showMyHouseRent(int rid) {
        return houseRentMapper.updateHouseStatus(rid,0);
    }

    @Override
    public int deleteHouseRent(int rid) {
        return houseRentMapper.deleteHouseRent(rid);
    }

    @Override
    public int queryIsAllowDelete(int rid) {
        return houseRentMapper.queryHouseRentAllowDeleteBiHid(rid);
    }
}
