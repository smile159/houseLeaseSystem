package com.xinxin.controller;

import com.xinxin.bean.dto.ViewDetailHouseRent;
import com.xinxin.bean.dto.ViewHouseRent;
import com.xinxin.bean.query.ConditionsSearch;
import com.xinxin.bean.vo.CreateHouseRent;
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
@RequestMapping("house")
public class HouseRentController {

    @Autowired
    HouseRentService houseRentService;


    @GetMapping("/houseRentGlanceAddCount")
    public Result<String> houseRentAddGlance(int hid){
        return null;
    }



    /*
    * 按条件搜索
    * */
    @PostMapping("/conditionsSearch")
    public Result<List<ViewHouseRent>> conditionsSearch(@RequestBody ConditionsSearch conditionsSearch){
        return Result.success(houseRentService.queryConditionsSearch(conditionsSearch));
    }


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
    public Result<String> unshelveMyHouseRent(int rid) {
        return houseRentService.unshelveMyHouseRent(rid)>0 ? Result.success("下架成功") : Result.error("下架失败");
    }

    @GetMapping("/showMyHouseRent")
    public Result<String> shelveMyHouseRent(int rid) {
        return houseRentService.shelveMyHouseRent(rid)>0 ? Result.success("上架成功") : Result.error("上架失败");
    }


    @GetMapping("/deleteHouseRent")
    public Result<String> deleteHouseRent(int rid){
        if(houseRentService.queryIsAllowDelete(rid) == 0){
            return Result.error("管理员已禁止删除");
        }
        return houseRentService.deleteHouseRent(rid)>0 ? Result.success("删除成功") : Result.error("删除失败");
    }


    /*
    * 创建房屋租赁
    * */
    @PostMapping("/createHouseRent")
    public Result<String> createHouseRent(@RequestBody CreateHouseRent createHouseRent){
        System.out.println("create = "+createHouseRent);
        return houseRentService.createHouseRent(createHouseRent)>0 ? Result.success("发布成功") : Result.error("发布失败");
    }
}
