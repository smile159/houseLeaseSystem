package com.xinxin.controller;

import com.xinxin.bean.sql.HouseTag;
import com.xinxin.common.Result;
import com.xinxin.service.HouseTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author smile
 * @ClassName HouseTagController.java
 * @Description TODO
 * @createTime 2022年05月08日 21:20:00
 */
@RestController
public class HouseTagController {
    @Autowired
    HouseTagService houseTagService;

    @GetMapping("/getHouseAllTag")
    public Result<List<HouseTag>> getHouseAllTag(@RequestParam("hid") int hid){
        return Result.success(houseTagService.getHouseAllTag(hid));
    }
}
