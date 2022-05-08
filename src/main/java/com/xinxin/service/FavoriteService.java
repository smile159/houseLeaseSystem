package com.xinxin.service;

import com.xinxin.bean.dto.ViewHouseRent;
import com.xinxin.bean.vo.FavoriteHouseRent;

import java.util.List;

/**
 * @author smile
 * @ClassName FavoriteService.java
 * @Description TODO
 * @createTime 2022年05月05日 17:23:00
 */
public interface FavoriteService {

    /*用户收藏房屋出租信息*/
    public int userFavoriteHouseRent(FavoriteHouseRent favoriteHouseRent);

    /*用户取消收藏*/
    public int userCancelHouseRent(FavoriteHouseRent favoriteHouseRent);

    /*用户查看所有的收藏*/
    public List<ViewHouseRent> getAllFavorite(int uid);
}
