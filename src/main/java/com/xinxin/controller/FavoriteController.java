package com.xinxin.controller;

import com.xinxin.bean.vo.FavoriteHouseRent;
import com.xinxin.common.Result;
import com.xinxin.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author smile
 * @ClassName FavoriteController.java
 * @Description 收藏相关
 * @createTime 2022年05月05日 17:24:00
 */
@RestController
public class FavoriteController {
    @Autowired
    FavoriteService favoriteService;

    @PostMapping("/favoriteHouseRent")
    public Result<String> userFavoriteHouseRent(@RequestBody FavoriteHouseRent favoriteHouseRent){
        if(favoriteService.userFavoriteHouseRent(favoriteHouseRent)>0){
            return Result.success("收藏成功");
        }else{
            return Result.error("收藏失败");
        }
    }


    @PostMapping("/cancelHouseRent")
    public Result<String> userCancelHouseRent(@RequestBody FavoriteHouseRent favoriteHouseRent){
        if(favoriteService.userCancelHouseRent(favoriteHouseRent)>0){
            return Result.success("取消收藏成功");
        }else{
            return Result.error("取消收藏失败");
        }
    }

}
