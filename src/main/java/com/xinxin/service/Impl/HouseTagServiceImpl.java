package com.xinxin.service.Impl;

import com.xinxin.bean.sql.HouseTag;
import com.xinxin.mapper.HouseTagMapper;
import com.xinxin.service.HouseTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author smile
 * @ClassName HouseTagServiceImpl.java
 * @Description TODO
 * @createTime 2022年05月08日 21:24:00
 */
@Service
public class HouseTagServiceImpl implements HouseTagService {
    @Autowired
    HouseTagMapper houseTagMapper;

    @Override
    public List<HouseTag> getHouseAllTag(int hid) {
        return houseTagMapper.getHouseTagByHid(hid);
    }
}
