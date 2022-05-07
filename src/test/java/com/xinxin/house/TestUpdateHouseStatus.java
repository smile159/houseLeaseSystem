package com.xinxin.house;

import com.xinxin.service.HouseRentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

    @Test
    public void test01(){
        //int i = houseRentService.hiddenMyHouseRent(1);
        int i = houseRentService.showMyHouseRent(1);
        System.out.println(i);
    }
}
