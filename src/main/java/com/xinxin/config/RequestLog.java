package com.xinxin.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author smile
 * @ClassName RequestLog.java
 * @Description TODO
 * @createTime 2022年04月28日 11:28:00
 */
public class RequestLog implements HandlerInterceptor {
    /*
     * @param request
     * @param response
     * @param handler
     * @return boolean
     * @author smile
     * @date 2022/4/28 11:29
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 日志记录
        // 获取请求的路径
        System.out.println("getRequestURL：" + request.getRequestURL());
        System.out.println("getMethod：" + request.getMethod());
        System.out.println("getRequestURI：" + request.getRequestURI());
        System.out.println("getAuthType：" + request.getAuthType());
        System.out.println("getContextPath：" + request.getContextPath());
        System.out.println("handler："+handler);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
