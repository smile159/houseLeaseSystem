package com.xinxin.controller;

import com.xinxin.bean.vo.UserMessage;
import com.xinxin.common.Result;
import com.xinxin.service.MessageService;
import com.xinxin.utils.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author smile
 * @ClassName MessageController.java
 * @Description TODO
 * @createTime 2022年05月09日 10:23:00
 */
@RestController
public class MessageController {

    @Autowired
    MessageService messageService;

    @PostMapping("/userMessage")
    public Result<String> userMessage(@RequestBody UserMessage userMessage, HttpServletRequest request){
        userMessage.setCreateTime(DateTimeUtils.getNowDateTime());
        userMessage.setUid((int)request.getAttribute("userId"));
        return messageService.createUserMessage(userMessage)>0?Result.success("留言成功"):Result.error("留言失败");
    }
}
