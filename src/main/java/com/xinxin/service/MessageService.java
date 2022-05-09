package com.xinxin.service;

import com.xinxin.bean.dto.ViewUserMessage;
import com.xinxin.bean.sql.SqlUserMessage;
import com.xinxin.bean.vo.UserMessage;

import java.util.HashMap;
import java.util.List;

/**
 * @author smile
 * @ClassName MessageServiceImpl.java
 * @Description TODO
 * @createTime 2022年05月09日 10:25:00
 */
public interface MessageService {
    /*创建留言*/
    public int createUserMessage(UserMessage userMessage);
    /*查询符合条件的数据*/
    public HashMap<String,Object> getAllUserMessage(int uid, int pageSize, int pageNum,int read);
    /*修改未读为已读*/
    public int updateMessageRead(int mid);
    /*获取最新的留言数量*/
    public int getAllNoReadMessage(int uid);
}
