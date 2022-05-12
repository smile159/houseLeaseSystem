package com.xinxin.controller.admin;

import com.xinxin.bean.sql.House;
import com.xinxin.common.Result;
import com.xinxin.service.HouseRentService;
import com.xinxin.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author smile
 * @ClassName ManageHouseController.java
 * @Description TODO
 * @createTime 2022年05月12日 14:51:00
 */
@RestController
@RequestMapping("admin")
public class ManageHouseController {
    @Autowired
    HouseService houseService;

    /*
     * 分页获取房屋信息
     * */
    @GetMapping("getHousePaging")
    public Result<HashMap<String,Object>> getAllHouseByPaging(int pageSize, int pageNum){
        return Result.success(houseService.getAllHouseByPaging(pageSize,pageNum));
    }


    /*
    * 禁止查询
    * */
    @GetMapping("hiddenHouse")
    public Result<String> hiddenHouse(int hid){
        return houseService.disabledQueryHouseRent(hid)>0?Result.success("隐藏成功"):Result.error("隐藏失败");
    }

    /*
    * 取消禁止查询
    * */
    @GetMapping("showHouse")
    public Result<String> showHouse(int hid){
        return houseService.unDisabledQueryHouseRent(hid)>0?Result.success("取消成功"):Result.error("取消失败");
    }

    /*
    * 禁止删除
    * */
    @GetMapping("disableDelete")
    public Result<String> disabledHouseDelete(int hid){
        return houseService.disabledHouseDelete(hid)>0?Result.success("禁止删除成功"):Result.error("禁止删除失败");
    }

    /*
    * 取消禁止删除
    * */
    @GetMapping("allowDelete")
    public Result<String> allowHouseDelete(int hid){
        return houseService.allowHouseDelete(hid)>0?Result.success("取消禁止删除成功"):Result.error("取消禁止删除失败");
    }
}
