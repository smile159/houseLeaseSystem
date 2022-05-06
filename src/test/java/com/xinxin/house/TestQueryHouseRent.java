package com.xinxin.house;

import com.xinxin.bean.dto.ViewHouseRent;
import com.xinxin.bean.sql.HouseRent;
import com.xinxin.bean.sql.HouseTag;
import com.xinxin.mapper.HouseMapper;
import com.xinxin.mapper.HouseRentMapper;
import com.xinxin.mapper.HouseTagMapper;
import com.xinxin.mapper.UserMapper;
import com.xinxin.service.HouseRentService;
import com.xinxin.service.HouseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.interfaces.PBEKey;
import java.util.List;

/**
 * @author smile
 * @ClassName TestQueryHouseRent.java
 * @Description 测试查询出租信息的分页功能
 * @createTime 2022年05月04日 16:03:00
 */
@SpringBootTest
public class TestQueryHouseRent {

    @Autowired
    HouseRentService houseRentService;
    @Autowired
    HouseRentMapper houseRentMapper;
    @Autowired
    HouseTagMapper houseTagMapper;

    @Test
    public void test01(){
        // 一页三条，查询第一页数据
        //List<ViewHouseRent> viewHouseRents = houseService.queryHouseRent(3, 1);
        List<ViewHouseRent> viewHouseRents = houseRentService.queryHouseRent(3, 2);
        for (ViewHouseRent viewHouseRent : viewHouseRents) {
            System.out.println(viewHouseRent);
        }
    }

    @Test
    public void test02(){
        List<ViewHouseRent> recommendHouseRent = houseRentMapper.getRecommendHouseRent();
        for (ViewHouseRent viewHouseRent : recommendHouseRent) {
            System.out.println(viewHouseRent);
        }
    }

    @Test
    public void test03(){
        List<HouseTag> houseTagByHidAndTwo = houseTagMapper.getHouseTagByHidAndTwo(1);
        System.out.println(houseTagByHidAndTwo);
    }
}
