package com.simo.dao.entity.auth;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
* 权限控制-页面访问表
* @TableName t_auth_menu
*/
@Entity
@Table(name = "t_auth_menu")
@Data
public class AuthMenu implements Serializable {

    /**
    * 主键id
    */
    @ApiModelProperty("主键id")
    @Id
    private String id;
    /**
    * 菜单项目名称
    */
    @ApiModelProperty("菜单项目名称")
    private String name;
    /**
    * 唯一编码
    */
    @ApiModelProperty("唯一编码")
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
