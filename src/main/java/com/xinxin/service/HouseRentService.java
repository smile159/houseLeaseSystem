package com.xinxin.service;

import com.xinxin.bean.dto.ViewDetailHouseRent;
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
    // 分页查询
    public List<ViewHouseRent> queryHouseRent(int pageSize, int pageNum);
    // 推荐数据
    public List<ViewHouseRent> getRecommendHouseRent();
    // 我的租赁
    public List<ViewHouseRent> getMyHouseRentById(int uid,int type);
    // 根据rid查询所有字段以及租客用户名
    public ViewDetailHouseRent getMyHouseRentDetailData(int rid);
    // 修改出租信息
    public int updateMyHouseRent(ViewDetailHouseRent viewDetailHouseRent);
    // 下架出租信息
    public int hiddenMyHouseRent(int rid);
    // 上架出租信息
    public int showMyHouseRent(int rid);
    // 删除
    public int deleteHouseRent(int rid);
    // 查询是否允许删除
    public int queryIsAllowDelete(int rid);
}
