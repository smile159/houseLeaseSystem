package com.xinxin.mapper;

import com.xinxin.bean.vo.UserMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author smile
 * @ClassName MessageMapper.java
 * @Description TODO
 * @createTime 2022年05月09日 10:23:00
 */
@Mapper
public interface MessageMapper {

    @Insert("insert into user_message(mid, uid, rid, message, create_time)  values (null,#{uid},#{rid},#{message},#{createTime})")
    public int createUserMessage(UserMessage userMessage);
}
