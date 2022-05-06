package com.xinxin.service.Impl;

import com.xinxin.bean.vo.FavoriteHouseRent;
import com.xinxin.mapper.FavoriteMapper;
import com.xinxin.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author smile
 * @ClassName FavoriteServiceImpl.java
 * @Description TODO
 * @createTime 2022年05月05日 17:23:00
 */
@Service
public class FavoriteServiceImpl implements FavoriteService {
    @Autowired
    FavoriteMapper favoriteMapper;
    @Override
    public int userFavoriteHouseRent(FavoriteHouseRent favoriteHouseRent) {
        // 先生成fid
        int userFavorite = favoriteMapper.createUserFavorite(favoriteHouseRent);
        if(userFavorite<0){
            return -1;
        }
        // 更新出租信息的fid
        return favoriteMapper.favoriteHouseRent(favoriteHouseRent.getRid(), favoriteHouseRent.getFid());
    }
}
