package com.xinxin.controller;

import com.xinxin.common.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author smile
 * @ClassName FavoriteController.java
 * @Description 收藏相关
 * @createTime 2022年05月05日 17:24:00
 */
@RestController
public class FavoriteController {

    @PostMapping("/favoriteHouseRent")
    public Result<String> userFavoriteHouseRent(){
        return Result.error("ss");
    }

}
