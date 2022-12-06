package com.simo.dao.entity.auth;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
* 权限控制--角色表
* @TableName t_auth_role
*/
@Entity
@Table(name = "t_auth_role")
@Data
public class AuthRole implements Serializable {

    /**
    * 主键id
    */
    @Id
    @ApiModelProperty("主键id")
    private String id;
    /**
    * 角色名称
    */
    @ApiModelProperty("角色名称")
    private String name;
    /**
    * 角色唯一编码
    */
    
    @ApiModelProperty("角色唯一编码")
    private String code;
    /**
    * 创建时间
    */
    @ApiModelProperty("创建时间")
    private Date createtime;
    /**
    * 更新时间
    */
    @ApiModelProperty("更新时间")
    private Date updatetime;

}
