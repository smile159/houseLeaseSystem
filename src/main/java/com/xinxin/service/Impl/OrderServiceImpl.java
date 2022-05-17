package com.xinxin.service.Impl;

import com.xinxin.bean.dto.ViewReserveOrder;
import com.xinxin.bean.vo.ReserveOrder;
import com.xinxin.mapper.OrderMapper;
import com.xinxin.mapper.UserMapper;
import com.xinxin.service.OrderService;
import com.xinxin.utils.DateTimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName OrderService.java
 * @author smile
 * @Description TODO
 * @createTime 2022年05月09日 09:31:00
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
     @Autowired
    OrderMapper orderMapper;

    @Override
    public int userReserveHouseRent(ReserveOrder reserveOrder, HttpServletRequest request) {
        // 缺少用户名和创建日期
        reserveOrder.setCreateTime(DateTimeUtils.getNowDateTime());
        reserveOrder.setUserName(request.getAttribute("userName").toString());
        log.info("reserveOrder = {}",reserveOrder);
        return orderMapper.createReserveOrder(reserveOrder);
    }

    @Override
    public ViewReserveOrder queryUserOrder(int rid,String userName) {
        return orderMapper.queryOrder(rid,userName);
    }
}
