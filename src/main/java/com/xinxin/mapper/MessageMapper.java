package com.xinxin.mapper;

import com.xinxin.bean.dto.ViewUserMessage;
import com.xinxin.bean.sql.SqlUserMessage;
import com.xinxin.bean.vo.UserMessage;
import org.apache.ibatis.annotations.*;

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
    @Insert("insert into user_message(mid, uid, rid, message, create_time)  values (null,#{uid},#{rid},#{message},#{createTime})")
    public int createUserMessage(UserMessage userMessage);

    /*分页查询*/
    public List<ViewUserMessage> getAllUserMessageBypaging(@Param("uid") int uid, @Param("offset") int offset, @Param("pageSize") int pageSize);
}
