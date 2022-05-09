package com.xinxin.commet;

import com.xinxin.bean.dto.ViewUserMessage;
import com.xinxin.service.MessageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

/**
 * @author smile
 * @ClassName TestUserMessage.java
 * @Description TODO
 * @createTime 2022年05月09日 15:02:00
 */
@SpringBootTest
public class TestUserMessage {
    @Autowired
    MessageService messageService;

    @Test
    public void test01(){
        HashMap<String, Object> allUserMessage = messageService.getAllUserMessage(1, 10, 1,0);
        System.out.println(allUserMessage);
    }

    @Test
    public void test02(){
        int allNoReadMessage = messageService.getAllNoReadMessage(1);
        System.out.println("未读数量为："+allNoReadMessage);
    }
}
