package com.xinxin.common;

import com.xinxin.response.ResultEnum;
import lombok.Data;


@Data
public class Result<T>{
    //请求的响应状态
    private final Integer status;
    //请求的响应信息
    private final String msg;
    //请求的响应数据
    private T data;

    //构造函数
    // 1.没有data的构造函数
    public Result(Integer status, String msg){
        this.status = status;
        this.msg = msg;
    }


    // 2.有data的构造函数
    public Result(Integer status, String msg, T data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    // 成功的方法请求无返回值
    public static <T> Result<T> success(){
        return new Result<T>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg());
    }

    // 成功的请求方法，有返回值
    public static <T> Result<T> sussess(T data){
        return new Result<T>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(),data);
    }

    // 成功的请求，自定义msg
    public static <T> Result<T> sussess(String msg){
        return new Result<T>(ResultEnum.SUCCESS.getCode(), msg);
    }

    // 成功的请求，自定义msg和data
    public static <T> Result<T> sussess(String msg, T data){
        return new Result<T>(ResultEnum.SUCCESS.getCode(),msg,data);
    }


    // 失败的请求 无返回值
    public static <T> Result<T> error(){
        return new Result<T>(ResultEnum.REJECT.getCode(), ResultEnum.REJECT.getMsg());
    }


    // 失败的请求 有返回值
    public static <T> Result<T> error(T data){
        return new Result<T>(ResultEnum.REJECT.getCode(), ResultEnum.REJECT.getMsg(),data);
    }

    // 失败的请求 无返回值，自定义msg
    public static <T> Result<T> error(String msg){
        return new Result<T>(ResultEnum.REJECT.getCode(),msg);
    }


    // 失败的请求 无返回值，自定义msg和data
    public static <T> Result<T> error(String msg, T data){
        return new Result<T>(ResultEnum.REJECT.getCode(),msg,data);
    }

    public static <T> Result<T> error(int code, String msg, T data){
        return new Result<T>(code,msg,data);
    }


    public static <T> Result<T> error(int code,String msg){
        return new Result<T>(code,msg);
    }



}
