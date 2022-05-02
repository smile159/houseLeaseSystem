package com.xinxin.config.jwt;


import com.xinxin.bean.User;
import com.xinxin.common.excepiton.UserExcepiton;
import com.xinxin.custom.annotation.PassToken;
import com.xinxin.service.UserService;
import com.xinxin.utils.CookieUtils;
import com.xinxin.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author smile
 * @ClassName JwtAuthenticationInterceptor.java
 * @Description TODO
 * @createTime 2022年04月27日 20:11:00
 */
@Slf4j
public class JwtAuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        System.out.println("请求的路径为："+httpServletRequest.getRequestURI());
        String token = CookieUtils.getSpecifiedCookie(httpServletRequest.getCookies(),"token");
        System.out.println("token = "+token);
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                log.info("存在passtoken注解，校验通过");
                return true;
            }
        }
        //默认全部检查
        else {
            log.info("请求被拦截，需要进行token校验");
            // 执行认证
            if (token == null) {
                //这里其实是登录失效,没token了   这个错误也是我自定义的，读者需要自己修改
                log.info("token为空，校验失败!!!!");
                throw new UserExcepiton.UserNoToken("用户token为空");
            }

            // 获取 token 中的 id
            String userId = JwtUtils.getAudience(token);

            //找找看是否有这个user   因为我们需要检查用户是否存在，读者可以自行修改逻辑
            User user = userService.getUserById(userId);
            if (user == null) {
                //这个错误也是我自定义的
                log.info("用户不存在");
                return false;
            }

            // 验证 token
            return JwtUtils.verifyToken(token, userId);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }
}
