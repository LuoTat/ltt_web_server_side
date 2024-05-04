package com.luotat.Result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result
{
    private Integer code;//响应码，1 代表成功; 0 代表失败
    private String msg;  //响应码 描述字符串
    private Object data; //返回的数据

    //成功响应
    public static Result success()
    {
        return new Result(1, "success", null);
    }

    //成功响应
    public static Result success(String msg)
    {
        return new Result(1, msg, null);
    }

    //成功响应
    public static Result success(Object data)
    {
        return new Result(1, "success", data);
    }

    //成功响应
    public static Result success(Object data, String msg)
    {
        return new Result(1, msg, data);
    }

    //失败响应
    public static Result error(String msg)
    {
        return new Result(0, msg, null);
    }
}