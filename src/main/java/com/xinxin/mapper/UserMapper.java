package com.xinxin.mapper;

import com.xinxin.bean.dto.ViewUser;
import com.xinxin.bean.sql.User;
import com.xinxin.bean.vo.EditUserForm;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;

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
    @Insert("insert into user(user_name,password,identity,status) values(#{userName},#{password},#{identity},#{status} )")
    public int insertUser(User user);


    // 获取所有用户，分页查询
    @Select("select * from user limit #{offset},#{pageSize}")
    public List<User> getUserByPaging(@Param("offset") int offset,@Param("pageSize") int pageSize);

    /*
    * 用户统计
    * */
    @Select("select count(*) from user")
    public int queryAllUserCount();

    /*
    * 修改用户的状态
    * */

    @Update("update user set status=#{status} where uid=#{uid}")
    public int updateUserStatus(@Param("uid") int uid,@Param("status") int status);

    /*
    * 判断是否为黑名单用户
    * */
    @Select("select measure from user_blacklist where ban_id=#{uid}")
    public Integer checkBlackUser(@Param("uid") int uid);


    /*
    * 删除用户
    * */
    @Delete("delete from user where uid=#{uid}")
    public int deleteUserByUid(@Param("uid") int uid);


    /*
    * 用户修改
    * */
    @Update("update user set user_name=#{userName},password=#{password} where uid=#{uid}")
    public int editUserByUid(@RequestBody EditUserForm editUserForm);

    /*
    * 解除限制
    * */
    @Update("update user_blacklist set status=0 where ban_id=#{uid}")
    public int relieveUser(@Param("uid") int uid);

}
