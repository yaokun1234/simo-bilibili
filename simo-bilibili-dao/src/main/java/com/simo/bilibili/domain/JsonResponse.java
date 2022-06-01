package com.simo.bilibili.domain;

import lombok.Data;

@Data
public class JsonResponse<T> {
    private String code;

    private String msg;

    private T data;

    public JsonResponse(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public JsonResponse(T data){
        this.code = "0";
        this.msg = "成功";
        this.data = data;
    }

    public static JsonResponse<String> success(){
        return new JsonResponse<>(null);
    }

    public static JsonResponse<String> success(String data){
        return new JsonResponse<>(data);
    }

    public static JsonResponse<String> fail(){
        return new JsonResponse<>("1","失败");
    }

    public static JsonResponse<String> fail(String code,String data){
        return new JsonResponse<>("1","失败");
    }
}
