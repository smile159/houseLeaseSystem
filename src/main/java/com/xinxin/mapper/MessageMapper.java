package com.xinxin.mapper;

import com.xinxin.bean.dto.ViewUserMessage;
import com.xinxin.bean.sql.SqlUserMessage;
import com.xinxin.bean.vo.UserMessage;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author smile
 * @ClassName MessageMapper.java
 * @Description TODO
 * @createTime 2022年05月09日 10:23:00
 */
@Mapper
public interface MessageMapper {

    /*创建留言*/
    @Insert("insert into user_message(mid, uid, rid, message, create_time, `read`)  values (null,#{uid},#{rid},#{message},#{createTime},0)")
    public int createUserMessage(UserMessage userMessage);

    /*分页查询*/
    public List<ViewUserMessage> getAllUserMessageBypaging(@Param("uid") int uid, @Param("offset") int offset, @Param("pageSize") int pageSize,@Param("read") int read);

    /*
    * 总记录条数
    * */
    @Select("select count(*) from user_message um where uid=#{uid} and um.read=#{read}")
    public int getAllMessageTotal(@Param("uid")int uid,@Param("read") int read);

    /*
    * 更新已读的状态，未读变为已读
    * */
    @Update("update user_message um set um.read=1 where mid=#{mid} ")
    public int updateMessageRead(@Param("mid") int mid);
}
