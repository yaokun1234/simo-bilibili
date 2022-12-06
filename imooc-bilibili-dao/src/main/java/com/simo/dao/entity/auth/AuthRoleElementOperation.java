package com.simo.dao.entity.auth;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
* 权限控制--角色与元素操作关联表
* @TableName t_auth_role_element_operation
*/
@Entity
@Table(name = "t_auth_role_element_operation")
@Data
public class AuthRoleElementOperation implements Serializable {

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
    * 元素操作id
    */
    
//    @ApiModelProperty("元素操作id")
//    private String elementoperationid;
    /**
    * 创建时间
    */
    @ApiModelProperty("创建时间")
    private Date createtime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "elementoperationid")
    @ApiModelProperty("对应的操作元素")
    private AuthElementOperation authElementOperation;


}
