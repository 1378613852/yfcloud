package com.yfcloud.springcloud.entitles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable {
    private int code;
    private String msg;
    private T t;

    public CommonResult (int code , String msg){
        this.code = code;
        this.msg = msg;
    }
}
