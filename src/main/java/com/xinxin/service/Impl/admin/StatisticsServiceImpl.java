package com.xinxin.service.Impl.admin;

import com.xinxin.bean.admin.dto.Statistics;
import com.xinxin.mapper.admin.StatisticsMapper;
import com.xinxin.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author smile
 * @ClassName StatisticsServiceImpl.java
 * @Description TODO
 * @createTime 2022年05月12日 21:38:00
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    StatisticsMapper statisticsMapper;


    @Override
    public Statistics getAllStatistics() {
        return Statistics.builder()
                .userCount(statisticsMapper.queryUserCount())
                .houseCount(statisticsMapper.queryHouseCount())
                .houseRentCount(statisticsMapper.queryHouseRentCount())
                .build();
    }
}
