package com.xinxin.service;

import com.xinxin.bean.dto.ViewDetailHouseRent;
import com.xinxin.bean.dto.ViewHouseDetail;
import org.apache.ibatis.annotations.Param;

/**
 * @author smile
 * @ClassName DetailService.java
 * @Description TODO
 * @createTime 2022年05月08日 21:12:00
 */
public interface DetailService {
    public ViewHouseDetail getAllDataByHouseRentRid(@Param("rid") int rid);
}
