package com.xinxin.service;

import com.xinxin.bean.sql.User;
import com.xinxin.bean.vo.EditUserForm;
import com.xinxin.bean.vo.RegisterUser;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @author smile
 * @ClassName UserService.java
 * @Description TODO
 * @createTime 2022年04月27日 14:19:00
 */
public interface UserService {
    public User getUserByName(@Param("userName") String userName);

    public User getUserById(@Param("uid") String uid);

    public boolean registerUser(@Param("user") RegisterUser user);

    public HashMap<String,Object> getUserByPaging(int pageSize, int pageNum);

    /*
    * 检测是否为黑名单用户
    * */
    public boolean checkUserIsBan(int uid);

    /*
    * 删除用户
    * */
    public int deleteUser(int uid);

    /*
    * 编辑用户
    * */

    public int editUser(EditUserForm editUserForm);

    /*
    * 解除限制
    * */
    public int relieveUser(int uid);
}
