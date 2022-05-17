package com.xinxin.service;

import com.xinxin.bean.dto.ViewReserveOrder;
import com.xinxin.bean.vo.ReserveOrder;

import javax.servlet.http.HttpServletRequest;

/**
 * @author smile
 * @ClassName OrderService.java
 * @Description TODO
 * @createTime 2022年05月09日 09:31:00
 */
public interface OrderService {

    public int userReserveHouseRent(ReserveOrder reserveOrder, HttpServletRequest request);

    public ViewReserveOrder queryUserOrder(int rid,String userName);
}
