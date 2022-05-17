package com.xinxin.controller.admin;

import com.xinxin.bean.admin.dto.Statistics;
import com.xinxin.bean.dto.ViewStatistics;
import com.xinxin.common.Result;
import com.xinxin.service.HouseService;
import com.xinxin.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author smile
 * @ClassName StatisticsController.java
 * @Description TODO
 * @createTime 2022年05月12日 21:31:00
 */
@RestController
@RequestMapping("house/admin")
public class StatisticsController {

    @Autowired
    StatisticsService statisticsService;

    @Autowired
    HouseService houseService;

    // 统计用户数量、租赁数量、房屋数量
    @GetMapping("getStatistics")
    public Result<Statistics> getStatistics(){
        return Result.success(statisticsService.getAllStatistics());
    }



    @GetMapping("/getHouseRentAndUserGlance")
    public Result<ViewStatistics> getHouseRentAndUserGlance(){
        return Result.success(houseService.queryHouseRentAndUserGlance());
    }
}
