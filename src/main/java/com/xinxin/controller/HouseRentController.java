package com.xinxin.controller;

import com.xinxin.bean.dto.ViewHouseRent;
import com.xinxin.bean.sql.HouseRent;
import com.xinxin.common.Result;
import com.xinxin.custom.annotation.PassToken;
import com.xinxin.service.HouseRentService;
import com.xinxin.service.HouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.View;
import java.util.List;

/**
 * @author smile
 * @ClassName HouseRentController.java
 * @Description 房屋出租相关
 * @createTime 2022年05月04日 10:01:00
 */
@RestController
@Slf4j
public class HouseRentController {

    @Autowired
    HouseRentService houseRentService;

    /*分页查询*/
    @PassToken
    @GetMapping("/RecommendHouseRent")
    public Result<List<ViewHouseRent>> getHouseRent(){
        // 查询数据库
        return Result.success(houseRentService.getRecommendHouseRent());
    }
}
