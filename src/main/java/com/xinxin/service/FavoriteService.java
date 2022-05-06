package com.xinxin.service;

import com.xinxin.bean.vo.FavoriteHouseRent;

/**
 * @author smile
 * @ClassName FavoriteService.java
 * @Description TODO
 * @createTime 2022年05月05日 17:23:00
 */
public interface FavoriteService {

    /*用户收藏房屋出租信息*/
    public int userFavoriteHouseRent(FavoriteHouseRent favoriteHouseRent);
}
