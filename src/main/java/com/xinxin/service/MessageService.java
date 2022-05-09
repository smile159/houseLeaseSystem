package com.xinxin.service;

import com.xinxin.bean.dto.ViewUserMessage;
import com.xinxin.bean.sql.SqlUserMessage;
import com.xinxin.bean.vo.UserMessage;

import java.util.List;

/**
 * @author smile
 * @ClassName MessageServiceImpl.java
 * @Description TODO
 * @createTime 2022年05月09日 10:25:00
 */
public interface MessageService {
    public int createUserMessage(UserMessage userMessage);
    public List<ViewUserMessage> getAllUserMessage(int uid, int pageSize, int pageNum);
}
