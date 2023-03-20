package com.hong.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private int code;
    private String msg;
    private T data;

    public Result<T> success(T data) {
        this.code = 200;
        this.msg = "成功";
        this.data = data;
        return this;
    }

    public Result<T> error() {
        this.code = 400;
        this.msg = "失败";
        this.data = null;
        return this;
    }

    public Result<T> error(String msg){
        this.code = 400;
        this.msg = msg;
        this.data = null;
        return this;
    }

}
