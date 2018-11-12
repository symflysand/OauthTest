package com.flysand.model.type;

public enum ErrorMsg {

    SUCCESS(1,"成功"),
    FAILED(0,"失败");

    private int code;

    private String msg;

    ErrorMsg(int code,String msg){
        this.code = code;
        this.msg = msg;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
