package com.xinxin.favorite;

import com.xinxin.bean.vo.FavoriteHouseRent;
import com.xinxin.mapper.FavoriteMapper;
import com.xinxin.service.FavoriteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author smile
 * @ClassName TestFavoriteHouseRent.java
 * @Description TODO
 * @createTime 2022年05月06日 14:05:00
 */
@SpringBootTest
public class TestFavoriteHouseRent {
    @Autowired
    FavoriteMapper favoriteMapper;

    @Autowired
    FavoriteService favoriteService;

    @Test
    public void test01(){
        FavoriteHouseRent favoriteHouseRent = new FavoriteHouseRent();
        favoriteHouseRent.setRid(4);
        favoriteHouseRent.setUid(1);
        int userFavorite = favoriteMapper.createUserFavorite(favoriteHouseRent);
        System.out.println(userFavorite);
        if(userFavorite > 0){
            System.out.println("插入成功");
            System.out.println("fid = "+favoriteHouseRent.getFid());
        }else{
            System.out.println("插入失败");
        }
    }

    @Test
    public void test02(){
        FavoriteHouseRent favoriteHouseRent = new FavoriteHouseRent();
        favoriteHouseRent.setRid(4);
        favoriteHouseRent.setUid(1);
        int userFavorite = favoriteService.userCancelHouseRent(favoriteHouseRent);
        System.out.println(userFavorite);
    }
}
