package com.cz.springcloud.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class JsonResult<T> {

    private Integer code;
    private String message;
    private T data;

    public JsonResult(Integer code, String message){
        this(code, message, null);
    }

   public JsonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
