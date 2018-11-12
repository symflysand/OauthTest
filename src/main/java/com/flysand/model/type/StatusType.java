package com.flysand.model.type;

/**
 * 状态枚举类
 */
public enum StatusType {
    NORMAL("正常"),
    ACCOUNT_LOCKED("账户锁定"),
    ACCOUNT_EXPIRED("账户过期"),
    CREDENTIAL_EXPIRED("密码过期"),
    UNABLE("账户不可用");


    private String value;

    StatusType(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
