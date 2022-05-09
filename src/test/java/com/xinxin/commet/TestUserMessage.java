package com.xinxin.commet;

import com.xinxin.bean.dto.ViewUserMessage;
import com.xinxin.service.MessageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        List<ViewUserMessage> allUserMessage = messageService.getAllUserMessage(1, 10, 1);
        for (ViewUserMessage viewUserMessage : allUserMessage) {
            System.out.println(viewUserMessage);
        }
    }
}
