package com.xinxin.service;

import com.xinxin.bean.sql.HouseTag;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author smile
 * @ClassName HouseTagService.java
 * @Description TODO
 * @createTime 2022年05月08日 21:24:00
 */
public interface HouseTagService {
    public List<HouseTag> getHouseAllTag(int hid);
}
