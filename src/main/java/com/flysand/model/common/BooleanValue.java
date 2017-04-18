package com.flysand.model.common;

import java.io.Serializable;

/**
 * Title:BooleanValue.java
 * Location:com.flysand.model.common
 * Author:flysand
 * Date:2017年03月31 15:11:30
 * Description: boolean返回对象
 **/
public class BooleanValue implements Serializable{

    private boolean value;

    public BooleanValue(){

    }

    public BooleanValue(boolean value){
        this.value = value;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
}
