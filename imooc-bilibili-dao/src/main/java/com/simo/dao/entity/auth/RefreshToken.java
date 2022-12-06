package com.simo.dao.entity.auth;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
* 刷新令牌记录表
* @TableName t_refresh_token
*/
@Entity
@Table(name = "t_refresh_token")
@Data
public class RefreshToken implements Serializable {

    /**
    * 主键id
    */
    @ApiModelProperty("主键id")
    @Id
    private String id;
    /**
    * 用户id
    */
    @ApiModelProperty("用户id")
    private String userid;
    /**
    * 刷新令牌
    */
    
    @ApiModelProperty("刷新令牌")
    private String refreshtoken;
    /**
    * 创建时间
    */
    @ApiModelProperty("创建时间")
    private Date createtime;


}
