package com.simo.dao.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "t_user")
@Entity
@Data
@ApiModel(description = "用户")
public class User {

    @Id
    @ApiModelProperty(value = "唯一值id")
    private String id;

    @ApiModelProperty(value = "手机号",required = true)
    private String phone;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "密码",required = true)
    private String password;

    @ApiModelProperty(value = "盐值")
    private String salt;

    @ApiModelProperty(value = "创建时间")
    @Column(name = "createTime")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @Column(name = "updateTime")
    private Date updateTime;

    @Transient
    @ApiModelProperty(value = "用户信息")
    private UserInfo userInfo;
}
