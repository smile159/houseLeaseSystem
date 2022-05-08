package com.xinxin.service.Impl;

import com.xinxin.bean.dto.ViewDetailHouseRent;
import com.xinxin.bean.dto.ViewHouseDetail;
import com.xinxin.mapper.DetailMapper;
import com.xinxin.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author smile
 * @ClassName DetailServiceImpl.java
 * @Description TODO
 * @createTime 2022年05月08日 21:13:00
 */
@Service
public class DetailServiceImpl implements DetailService {

    @Autowired
    DetailMapper detailMapper;

    @Override
    public ViewHouseDetail getAllDataByHouseRentRid(int rid) {
        return detailMapper.getAllDataByHouseRentRid(rid);
    }
}
