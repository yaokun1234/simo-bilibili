package com.simo.dao.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel(description = "JSON返回响响应体")
@Data
public class RespBean implements Serializable {

    @ApiModelProperty(value = "响应状态码")
    private int code;

    @ApiModelProperty(value = "响应信息")
    private String msg;

    @ApiModelProperty(value = "响应数据",required = false)
    private Object data;

    private static final int SUCCESS = 200;

    private static final int ERROR = 500;

    public RespBean(){
    }

    public RespBean(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public RespBean(int code, String msg, Object data){
        this.code = code;
        this.msg = msg;
        if(data != null){
            this.data = data;
        }
    }

    public static RespBean success(){
        return success("操作成功");
    }

    public static RespBean success(Object data){
        return success("操作成功", data);
    }

    public static RespBean success(String msg){
        return success(msg,null);
    }

    public static RespBean success(String msg, Object data){
        return new RespBean(SUCCESS, msg, data);
    }

    public static RespBean error(){
        return error("操作失败");
    }

    public static RespBean error(Object data){
        return error("操作失败", data);
    }

    public static RespBean error(String msg){
        return error(msg,null);
    }

    public static RespBean error(String msg, Object data){
        return new RespBean(ERROR, msg, data);
    }
}
