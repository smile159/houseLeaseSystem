package com.xinxin.service.Impl;

import com.xinxin.bean.dto.ViewDetailHouseRent;
import com.xinxin.bean.dto.ViewHouseRent;
import com.xinxin.bean.query.ConditionsSearch;
import com.xinxin.bean.vo.CreateHouseRent;
import com.xinxin.mapper.HouseRentMapper;
import com.xinxin.service.HouseRentService;
import com.xinxin.utils.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
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
    public List<ViewHouseRent> getRecommendHouseRent(Integer uid) {
        List<ViewHouseRent> recommendHouseRent = houseRentMapper.getRecommendHouseRent();
        for (ViewHouseRent viewHouseRent : recommendHouseRent) {
            if(uid != null){
                viewHouseRent.setFid(houseRentMapper.getFavoriteFidByRid(viewHouseRent.getRid(),uid));
            }else{
                viewHouseRent.setHouseStatus(0);
            }
        }
        System.out.println(recommendHouseRent);
        return recommendHouseRent;
    }

    @Override
    public List<ViewHouseRent> getMyHouseRentById(int uid, int type) {
        if (type == 2) {//租客租赁的数据
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

    /*
    * 下架房屋信息
    * */
    @Override
    public int unshelveMyHouseRent(int rid) {
        return houseRentMapper.updateHouseStatus(rid,0);
    }

    /*
    * 上架房屋信息
    * */
    @Override
    public int shelveMyHouseRent(int rid) {
        return houseRentMapper.updateHouseStatus(rid,1);
    }

    @Override
    public int deleteHouseRent(int rid) {
        return houseRentMapper.deleteHouseRent(rid);
    }

    @Override
    public int queryIsAllowDelete(int rid) {
        return houseRentMapper.queryHouseRentAllowDeleteBiHid(rid);
    }

    @Override
    public int addGlance(int hid) {
        return houseRentMapper.addGlance(hid);
    }

    @Override
    public List<ViewHouseRent> queryConditionsSearch(ConditionsSearch conditionsSearch) {
        return houseRentMapper.conditionsSearch(conditionsSearch);
    }

    @Override
    public int createHouseRent(CreateHouseRent createHouseRent) {
        createHouseRent.setCustomUid(0);
        createHouseRent.setHouseStatus(1);
        createHouseRent.setAllowDelete(1);
        createHouseRent.setAllowHidden(1);
        createHouseRent.setCreateTime(DateTimeUtils.getNowDateTime());
        createHouseRent.setUpdateTime(DateTimeUtils.getNowDateTime());
        System.out.println("impl "+createHouseRent);
        return houseRentMapper.insertHouseRent(createHouseRent);
    }
}
