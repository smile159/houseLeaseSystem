package com.xinxin.utils;

import javax.servlet.http.Cookie;

/**
 * @author smile
 * @ClassName CookieUtils.java
 * @Description TODO
 * @createTime 2022年04月27日 22:26:00
 */
public class CookieUtils {


    /*
     * @param cookies   request获取的cookie数组
     * @param name      要获取的key值
     * @return java.lang.String/null
     * @author smile
     * @date 2022/4/28 11:01
     */
    public static String getSpecifiedCookie(Cookie[] cookies , String name){
        if(cookies == null) return null;
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals(name))
            return cookie.getValue();
        }
        // 没有返回null
        return null;
    }

    /*
     * @param keyName   键的名称
     * @param value     value的值
     * @param maxAge    过期时间 负数表示不设置
     * @param HttpOnly  是否JS禁止获取
     * @return javax.servlet.http.Cookie
     * @author smile
     * @date 2022/4/28 11:05
     */
    public static Cookie createCookie(String keyName,String value,int maxAge,boolean HttpOnly){
        Cookie cookie = new Cookie(keyName,value);
        cookie.setMaxAge(maxAge);
        cookie.setHttpOnly(HttpOnly);
        return cookie;
    }


}
