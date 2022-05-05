package com.xinxin.mapper;

import com.xinxin.bean.sql.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
    // 获取所有的用户
    @Select("select * from user")
    public List<User> getAllUser();

    // 根据name查询用户
    @Select("select * from user where user_name=#{userName}")
    public User getUserByName(@Param("userName") String userName);


    // 根据id查询用户
    @Select("select * from user where uid=#{uid}")
    public User getUserById(@Param("uid") String uid);

    // 用户注册
    @Insert("insert into user(user_name,password,identity,status,token) values(#{userName},#{password},#{identity},#{status},#{token} )")
    public int insertUser(User user);


}
