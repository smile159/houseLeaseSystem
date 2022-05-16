package com.xinxin.house;

import com.xinxin.bean.dto.ViewHouseRent;
import com.xinxin.bean.query.ConditionsSearch;
import com.xinxin.mapper.HouseRentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author smile
 * @ClassName HouseRentTest.java
 * @Description TODO
 * @createTime 2022年05月16日 22:41:00
 */
@SpringBootTest
public class HouseRentTest {

    @Autowired
    HouseRentMapper houseRentMapper;

    @Test
    public void test01(){
        ConditionsSearch conditionsSearch = new ConditionsSearch();
        conditionsSearch.setAddress("天府街道");
        conditionsSearch.setSelectCityName("成都");
        conditionsSearch.setPriceStart(5000);
        conditionsSearch.setPriceEnd(8000);
        List<ViewHouseRent> viewHouseRents = houseRentMapper.conditionsSearch(conditionsSearch);
        System.out.println(viewHouseRents);
    }
}
