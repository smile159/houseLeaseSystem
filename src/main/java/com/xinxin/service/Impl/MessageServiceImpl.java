package com.xinxin.service.Impl;

import com.xinxin.bean.dto.ViewUserMessage;
import com.xinxin.bean.sql.SqlUserMessage;
import com.xinxin.bean.vo.UserMessage;
import com.xinxin.mapper.MessageMapper;
import com.xinxin.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

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


    @Override
    public HashMap<String,Object> getAllUserMessage(int uid, int pageSize, int pageNum,int read) {
        // 计算偏移量
        int offset = (pageNum -1) * pageSize;
        // 返回数据
        HashMap<String,Object> result = new HashMap<>();
        //查出所有数据(read=0表示未读)
        List<ViewUserMessage> allUserMessageBypaging = messageMapper.getAllUserMessageBypaging(uid, offset, pageSize,read);
        // 添加到hashmap中
        result.put("result",allUserMessageBypaging);
        // 再查询符合条件的总条数
        int allMessageTotal = messageMapper.getAllMessageTotal(uid, read);
        result.put("total",allMessageTotal);
        return result;

    }

    @Override
    public int updateMessageRead(int mid) {
        return messageMapper.updateMessageRead(mid);
    }

    @Override
    public int getAllNoReadMessage(int uid) {
        // 获取未读的所有数据数量
        return messageMapper.getAllMessageTotal(uid,0);
    }
}
