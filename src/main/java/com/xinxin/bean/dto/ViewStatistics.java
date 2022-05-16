package com.xinxin.bean.dto;

import com.xinxin.bean.query.StatisticsHouseRent;
import com.xinxin.bean.query.StatisticsUser;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author smile
 * @ClassName ViewStatistics.java
 * @Description TODO
 * @createTime 2022年05月16日 21:10:00
 */
@Data
@Builder
public class ViewStatistics {
    private List<StatisticsHouseRent> houseRentGlance;
    private List<StatisticsUser> userGlance;
}
