package com.xinxin.house;

import com.xinxin.bean.sql.House;
import com.xinxin.service.HouseRentService;
import com.xinxin.service.HouseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author smile
 * @ClassName TestUpdateHouseStatus.java
 * @Description TODO
 * @createTime 2022年05月07日 20:36:00
 */
@SpringBootTest
public class TestUpdateHouseStatus {
    @Autowired
    HouseRentService houseRentService;

    @Autowired
    HouseService houseService;

    @Test
    public void test01(){
    }


    @Test
    public void test02(){
        List<House> allHouse = houseService.getAllHouse(1);
        for (House house : allHouse) {
            System.out.println(house);
        }
    }
    @Test
    public void test03(){
        int i = houseRentService.addGlance(1);
        System.out.println(i);
    }
}
