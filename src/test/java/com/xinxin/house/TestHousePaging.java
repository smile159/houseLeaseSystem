package com.xinxin.house;

import com.xinxin.bean.sql.House;
import com.xinxin.service.HouseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

/**
 * @author smile
 * @ClassName TestHousePaging.java
 * @Description TODO
 * @createTime 2022年05月12日 14:35:00
 */
@SpringBootTest
public class TestHousePaging {

    @Autowired
    HouseService houseService;

    @Test
    public void test01(){
        HashMap<String, Object> allHouseByPaging = houseService.getAllHouseByPaging(2, 1);
        System.out.println(allHouseByPaging);
    }
}
