package com.xinxin.service.Impl;

import com.xinxin.bean.dto.ViewHouseRent;
import com.xinxin.bean.sql.HouseRent;
import com.xinxin.mapper.HouseMapper;
import com.xinxin.mapper.HouseRentMapper;
import com.xinxin.service.HouseRentService;
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
        int offset = (pageNum-1)*pageSize;
        return houseRentMapper.getHouseRentByPaging(offset,pageSize);
    }

    @Override
    public List<ViewHouseRent> getRecommendHouseRent() {
        return houseRentMapper.getRecommendHouseRent();
    }
}
