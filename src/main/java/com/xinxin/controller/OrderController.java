package com.xinxin.controller;

import com.xinxin.bean.vo.ReserveOrder;
import com.xinxin.common.Result;
import com.xinxin.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author smile
 * @ClassName OrderController.java
 * @Description 订单相关
 * @createTime 2022年05月09日 09:20:00
 */
@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/reserveHouse")
    public Result<String> reserveHouseRent(@RequestBody ReserveOrder reserveOrder, HttpServletRequest request){
        return orderService.userReserveHouseRent(reserveOrder,request)>0?Result.success("预订成功"):Result.error("预订失败");
    }
}
