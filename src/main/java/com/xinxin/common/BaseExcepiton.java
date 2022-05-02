package com.xinxin.common;

/**
 * @author smile
 * @ClassName BaseExcepiton.java
 * @Description TODO
 * @createTime 2022年05月02日 21:12:00
 */
public abstract class BaseExcepiton extends Exception {
    private String message;

    public BaseExcepiton(String message) {
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
