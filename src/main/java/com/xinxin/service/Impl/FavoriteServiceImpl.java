package com.xinxin.service.Impl;

import com.xinxin.bean.dto.ViewHouseRent;
import com.xinxin.bean.vo.FavoriteHouseRent;
import com.xinxin.mapper.FavoriteMapper;
import com.xinxin.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public int  userFavoriteHouseRent(FavoriteHouseRent favoriteHouseRent) {
        /// 先查询是否有存在的记录
        Integer result = favoriteMapper.queryIsAlreadyExist(favoriteHouseRent);
        if(result == null){
            // 生成fid
            return favoriteMapper.createUserFavorite(favoriteHouseRent);
        }
        return 1;
    }

    @Override
    public int userCancelHouseRent(FavoriteHouseRent favoriteHouseRent) {
        // 先删除fid
        return favoriteMapper.deleteUserFavorite(favoriteHouseRent.getFid());
    }

    @Override
    public List<ViewHouseRent> getAllFavorite(int uid) {
        return favoriteMapper.getAllHouseRent(uid);
    }
}
