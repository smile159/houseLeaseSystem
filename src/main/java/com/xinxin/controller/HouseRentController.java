package com.xinxin.controller;

import com.xinxin.bean.dto.ViewDetailHouseRent;
import com.xinxin.bean.dto.ViewHouseRent;
import com.xinxin.common.Result;
import com.xinxin.custom.annotation.PassToken;
import com.xinxin.service.HouseRentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public Result<List<ViewHouseRent>> getHouseRent() {
        // 查询数据库
        return Result.success(houseRentService.getRecommendHouseRent());
    }

    // 分页查询
    @PassToken
    @GetMapping("/getHouseRent")
    public Result<List<ViewHouseRent>> getHouseRentBypaging(int pageSize, int pageNum) {
        log.info("pageSize = {}, pageNum = {}", pageSize, pageNum);
        return Result.success(houseRentService.queryHouseRent(pageSize, pageNum));
    }


    @GetMapping("/getMyHouseRent")
    public Result<List<ViewHouseRent>> getMyHouseRent(HttpServletRequest httpServletRequest, @RequestParam("type") int type) {
        log.info("请求的类型是type = " + type);
        // 获取本次请求的用户id
        int userId = (int) httpServletRequest.getAttribute("userId");
        System.out.println("用户ID为：" + userId);
        // 根据id查询house_rent中的对应数据，返回给前端
        return Result.success(houseRentService.getMyHouseRentById(userId, type));
    }

    @GetMapping("/getMyHouseRentDetail")
    public Result<ViewDetailHouseRent> getMyHouseRentDetail(int rid) {
        return Result.success(houseRentService.getMyHouseRentDetailData(rid));
    }


    @PostMapping("/editMyHouseRent")
    public Result<String> editMyHouseRent(@RequestBody ViewDetailHouseRent viewDetailHouseRent) {
        return houseRentService.updateMyHouseRent(viewDetailHouseRent) > 0 ? Result.success("修改成功") : Result.error("修改失败");
    }

    @GetMapping("/hiddenMyHouseRent")
    public Result<String> hiddenMyHouseRent(int rid) {
        return houseRentService.hiddenMyHouseRent(rid)>0 ? Result.success("下架成功") : Result.error("下架失败");
    }

    @GetMapping("/showMyHouseRent")
    public Result<String> showMyHouseRent(int rid) {
        return houseRentService.showMyHouseRent(rid)>0 ? Result.success("上架成功") : Result.error("上架失败");
    }


    @GetMapping("/deleteHouseRent")
    public Result<String> deleteHouseRent(int rid){
        return houseRentService.deleteHouseRent(rid)>0 ? Result.success("删除成功") : Result.error("删除失败");
    }
}
