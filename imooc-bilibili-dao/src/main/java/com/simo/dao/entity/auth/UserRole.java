package com.simo.dao.entity.auth;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
* 用户角色关联表
* @TableName t_user_role
*/
@Entity
@Table(name = "t_user_role")
@Data
public class UserRole implements Serializable {

    /**
    * 
    */
    @ApiModelProperty("")
    @Id
    private String id;
    /**
    * 用户id
    */
    @ApiModelProperty("用户id")
    private String userid;
//    /**
//    * 角色id
//    */
//    @ApiModelProperty("角色id")
//    private String roleid;
    /**
    * 创建时间
    */
    @ApiModelProperty("创建时间")
    private Date createtime;

    @OneToOne
    @JoinColumn(name = "roleid")
    private AuthRole authRole;

    public UserRole() {
        this.id = UUID.randomUUID().toString();
        this.createtime = new Date();
    }
}
