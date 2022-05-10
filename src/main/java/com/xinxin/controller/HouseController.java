package com.xinxin.controller;

import com.xinxin.bean.sql.House;
import com.xinxin.bean.vo.CreateHouse;
import com.xinxin.bean.vo.UpdateHouse;
import com.xinxin.common.Result;
import com.xinxin.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author smile
 * @ClassName HouseController.java
 * @Description 我的房屋相关
 * @createTime 2022年05月07日 09:59:00
 */
@RestController
public class HouseController {

    @Autowired
    HouseService houseService;

    @GetMapping("/getAllHouse")
    public Result<List<House>> getAllHouse(HttpServletRequest request){
        int uid = (int)request.getAttribute("userId");
        return Result.success(houseService.getAllHouse(uid));
    }

    @PostMapping("/createHouse")
    public Result<String> addHouse(HttpServletRequest request,@RequestBody CreateHouse createHouse){
        int uid = (int)request.getAttribute("userId");
        createHouse.setUid(uid);
        System.out.println("createHouse = "+ createHouse);
        return houseService.insertHouse(createHouse)>0?Result.success("添加成功"):Result.error("添加失败");
    }

    @GetMapping("/deleteHouse")
    public Result<String> deleteHouse(HttpServletRequest request,Integer hid){
        int uid = (int)request.getAttribute("userId");
        return houseService.deleteHouse(uid,hid)>0?Result.success("删除成功"):Result.error("删除失败");
    }

    @PostMapping("/updateHouse")
    public Result<String> updateHouse(HttpServletRequest request,@RequestBody UpdateHouse updateHouse){
        int uid = (int)request.getAttribute("userId");
        updateHouse.setUid(uid);
        System.out.println("updateHouse = "+updateHouse);
        return houseService.updateHouse(updateHouse)>0?Result.success("修改成功"):Result.error("修改失败");
    }


    @GetMapping("/getHouse")
    public Result<House> getHouse(int hid){
        return Result.success(houseService.getHouse(hid));
    }
}
