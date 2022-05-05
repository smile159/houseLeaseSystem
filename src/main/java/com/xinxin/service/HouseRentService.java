package com.xinxin.service;

import com.xinxin.bean.dto.ViewHouseRent;
import com.xinxin.bean.sql.HouseRent;

import java.util.List;

/**
 * @author smile
 * @ClassName HouseRentService.java
 * @Description TODO
 * @createTime 2022年05月04日 16:48:00
 */
public interface HouseRentService {
    public List<HouseRent> queryHouseRent(int pageSize, int pageNum);
    // 分页查询
    public List<ViewHouseRent> getRecommendHouseRent();
}
