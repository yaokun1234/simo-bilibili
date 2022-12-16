package com.simo.dao.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
* 文件表
* @TableName t_file
*/
@Entity
@Table(name = "t_file")
@Data
public class File implements Serializable {

    /**
    * 主键id
    */
    @ApiModelProperty("主键id")
    @Id
    private String id;
    /**
    * 文件存储路径
    */
    
    @ApiModelProperty("文件存储路径")
    private String url;
    /**
    * 文件类型
    */
    
    @ApiModelProperty("文件类型")
    private String type;
    /**
    * 文件md5唯一标识串
    */
    
    @ApiModelProperty("文件md5唯一标识串")
    private String md5;
    /**
    * 创建时间
    */
    @ApiModelProperty("创建时间")
    private Date createtime;

    public File() {
        this.id = String.valueOf(UUID.randomUUID());
    }
}
