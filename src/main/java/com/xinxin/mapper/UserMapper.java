package com.xinxin.mapper;

import com.xinxin.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author smile
 * @ClassName UserMpper.java
 * @Description TODO
 * @createTime 2022年04月27日 14:18:00
 */
@Mapper
public interface UserMapper {
    @Select("select * from user")
    public List<User> getAllUser();
}
