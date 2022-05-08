package com.xinxin;

import com.xinxin.bean.dto.ViewDetailHouseRent;
import com.xinxin.bean.dto.ViewHouseDetail;
import com.xinxin.service.DetailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author smile
 * @ClassName detail.java
 * @Description TODO
 * @createTime 2022年05月08日 21:14:00
 */
@SpringBootTest
public class detail {
    @Autowired
    DetailService detailService;

    @Test
    public void test01(){
        ViewHouseDetail viewHouseDetail = detailService.getAllDataByHouseRentRid(1);
        System.out.println(viewHouseDetail);
    }
}
