package com.xinxin.mapper.admin;

import com.xinxin.bean.admin.AdminLoginUser;
import com.xinxin.bean.admin.AdminUser;
import com.xinxin.bean.admin.vo.BanUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author smile
 * @ClassName AdminUserMapper.java
 * @Description TODO
 * @createTime 2022年05月11日 09:27:00
 */
@Mapper
public interface AdminUserMapper {

    @Select("select * from admin_user where account=#{account}")
    public AdminUser getAdminUserByAccount(@Param("account") String account);


    @Insert("insert into user_blacklist (operation_uid, ban_id, measure, reason, create_time, start_time, end_time,status) values (#{operationUid},#{banId},#{measure},#{reason},#{createTime},#{startTime},#{endTime},#{status});")
    public int insertUserBlackList(BanUser banUser);
}
