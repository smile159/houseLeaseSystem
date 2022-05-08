package com.xinxin.controller;

import com.xinxin.bean.dto.ViewHouseDetail;
import com.xinxin.common.Result;
import com.xinxin.service.DetailService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author smile
 * @ClassName DetailController.java
 * @Description 出租详情页面
 * @createTime 2022年05月08日 20:55:00
 */
@RestController
@Slf4j
public class DetailController {
    @Autowired
    DetailService detailService;

    @GetMapping("/getHouseDetail")
    public Result<ViewHouseDetail> getHouseDetail(@RequestParam("rid") int rid){
        log.info("rid = {}",rid);
        return Result.success(detailService.getAllDataByHouseRentRid(rid));
    }
}
