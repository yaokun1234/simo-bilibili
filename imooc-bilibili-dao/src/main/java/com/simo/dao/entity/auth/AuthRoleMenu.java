package com.simo.dao.entity.auth;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
* 权限控制--角色页面菜单关联表
* @TableName t_auth_role_menu
*/
@Entity
@Table(name = "t_auth_role_menu")
@Data
public class AuthRoleMenu implements Serializable {

    /**
    * 主键id
    */
    @Id
    @ApiModelProperty("主键id")
    private String id;
    /**
    * 角色id
    */
    @ApiModelProperty("角色id")
    private String roleid;
    /**
    * 页面菜单id
    */
//    @ApiModelProperty("页面菜单id")
//    private String menuid;
    /**
    * 创建时间
    */
    @ApiModelProperty("创建时间")
    private Date createtime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "menuid")
    @ApiModelProperty("菜单")
    private AuthMenu authMenu;

}
