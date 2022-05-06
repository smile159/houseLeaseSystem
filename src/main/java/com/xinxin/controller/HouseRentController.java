package com.xinxin.controller;

import com.xinxin.bean.dto.ViewHouseRent;
import com.xinxin.bean.sql.HouseRent;
import com.xinxin.common.Result;
import com.xinxin.custom.annotation.PassToken;
import com.xinxin.response.ResultEnum;
import com.xinxin.service.HouseRentService;
import com.xinxin.service.HouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PassToken
    @GetMapping("/RecommendHouseRent")
    public Result<List<ViewHouseRent>> getHouseRent(){
        // 查询数据库
        return Result.success(houseRentService.getRecommendHouseRent());
    }


    // 分页查询
    @PassToken
    @GetMapping("/getHouseRent")
    public Result<List<ViewHouseRent>> getHouseRentBypaging(int pageSize,int pageNum){
        log.info("pageSize = {}, pageNum = {}",pageSize,pageNum);
        return Result.success(houseRentService.queryHouseRent(pageSize,pageNum));
    }
}
