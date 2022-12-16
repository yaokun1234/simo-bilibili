package com.simo.dao.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
* 标签表
* @TableName t_tag
*/
@Entity
@Table(name = "t_tag")
@Data
public class Tag implements Serializable {

    /**
    * 主键id
    */
    @Id
    @ApiModelProperty("主键id")
    private Long id;
    /**
    * 标签名称
    */
    
    @ApiModelProperty("标签名称")
    private String name;
    /**
    * 
    */
    @ApiModelProperty("")
    private Date createtime;


}
