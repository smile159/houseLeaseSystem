package com.xinxin.utils;

import javax.servlet.http.Cookie;

/**
 * @author smile
 * @ClassName CookieUtils.java
 * @Description TODO
 * @createTime 2022年04月27日 22:26:00
 */
public class CookieUtils {


    // 从Cookie[]数组中获取指定的cookie
    public static String getSpecifiedCookie(Cookie[] cookies , String name){
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals(name))
            return cookie.getValue();
        }
        // 没有返回null
        return null;
    }
}
