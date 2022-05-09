package com.xinxin.service.Impl;

import com.xinxin.bean.vo.UserMessage;
import com.xinxin.mapper.MessageMapper;
import com.xinxin.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author smile
 * @ClassName MessageServiceImpl.java
 * @Description TODO
 * @createTime 2022年05月09日 10:25:00
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageMapper messageMapper;


    @Override
    public int createUserMessage(UserMessage userMessage) {
        return messageMapper.createUserMessage(userMessage);
    }
}
