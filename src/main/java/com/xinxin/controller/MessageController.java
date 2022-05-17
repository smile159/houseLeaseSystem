package com.xinxin.controller;

import com.xinxin.bean.dto.ViewUser;
import com.xinxin.bean.dto.ViewUserMessage;
import com.xinxin.bean.vo.UserMessage;
import com.xinxin.common.Result;
import com.xinxin.service.MessageService;
import com.xinxin.utils.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.View;
import java.util.HashMap;
import java.util.List;

/**
 * @author smile
 * @ClassName MessageController.java
 * @Description TODO
 * @createTime 2022年05月09日 10:23:00
 */
@RestController
@RequestMapping("house")
public class MessageController {

    @Autowired
    MessageService messageService;

    @PostMapping("/userMessage")
    public Result<String> userMessage(@RequestBody UserMessage userMessage, HttpServletRequest request){
        userMessage.setCreateTime(DateTimeUtils.getNowDateTime());
        userMessage.setUid((int)request.getAttribute("userId"));
        return messageService.createUserMessage(userMessage)>0?Result.success("留言成功"):Result.error("留言失败");
    }

    @GetMapping("/getAllMessage")
    public Result<HashMap<String,Object>> getAllMessage(HttpServletRequest request, @RequestParam("pageSize") int pageSize, @RequestParam("pageNum") int pageNum,int read){
        int uid = (int)request.getAttribute("userId");
        return Result.success(messageService.getAllUserMessage(uid, pageSize, pageNum,read));
    }

    @GetMapping("/readMessage")
    public Result<String> readUserMessage(int mid){
        return messageService.updateMessageRead(mid)>0?Result.success("修改状态成功"):Result.error("修改状态失败");
    }

    @GetMapping("/getMessageNum")
    public Result<Integer> getMessageNum(HttpServletRequest request){
        int uid = (int)request.getAttribute("userId");
        return Result.success(messageService.getAllNoReadMessage(uid));
    }
}
