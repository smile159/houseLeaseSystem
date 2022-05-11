package com.xinxin.response;

// 定义统一全局的API返回代码
public enum ResultEnum {
    //内部定义枚举
    REJECT(0,"拒绝请求"),
    SUCCESS(1,"请求成功"),
    ERROR(-1,"未登录，请先登录"),
    BANACCOUNT(4000,"您的账号已被封禁"),
    BANEDMESSAGE(4001,"您的账号已被禁言");



    Integer code;
    String msg;

    ResultEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
