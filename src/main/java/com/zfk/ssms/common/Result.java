package com.zfk.ssms.common;

import lombok.Data;

/**
 * @author ZFK
 */
@Data
public class Result<T>{
    T data;
    String msg;
    boolean flag;

    public Result() {

    }

    public Result(T data, String msg, boolean flag) {
        this.data = data;
        this.msg = msg;
        this.flag = flag;
    }

    public static <T> Result<T> success(T data, String msg) {
        return new Result(data, msg, true);
    }

    public static <T> Result<T> fail(T data, String msg) {
        return new Result(null, msg, false);
    }

}
