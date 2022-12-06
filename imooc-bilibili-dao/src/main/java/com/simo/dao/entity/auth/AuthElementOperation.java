package com.simo.dao.entity.auth;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
* 权限控制--页面元素操作表
* @TableName t_auth_element_operation
*/
@Entity
@Table(name = "t_auth_element_operation")
@Data
public class AuthElementOperation implements Serializable {

    /**
    * 主键id
    */
    @Id
    @ApiModelProperty("主键id")
    private String id;
    /**
    * 页面元素名称
    */
    @ApiModelProperty("页面元素名称")
    private String elementname;
    /**
    * 页面元素唯一编码
    */
    @ApiModelProperty("页面元素唯一编码")
    private String elementcode;
    /**
    * 操作类型：0可点击  1可见
    */
    @ApiModelProperty("操作类型：0可点击  1可见")
    private String operationtype;
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
