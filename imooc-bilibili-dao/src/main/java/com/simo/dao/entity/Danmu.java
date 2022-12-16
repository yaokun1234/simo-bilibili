package com.simo.dao.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
* 弹幕记录表
* @TableName t_danmu
*/
@Entity
@Table(name = "t_danmu")
@Data
public class Danmu implements Serializable {

    /**
    * 主键id
    */
    @Id
    @ApiModelProperty("主键id")
    private Long id;
    /**
    * 用户id
    */
    @ApiModelProperty("用户id")
    private Long userid;
    /**
    * 视频Id
    */
    @ApiModelProperty("视频Id")
    private Long videoid;
    /**
    * 弹幕内容
    */
    @ApiModelProperty("弹幕内容")
    private String content;
    /**
    * 弹幕出现时间
    */
    @ApiModelProperty("弹幕出现时间")
    private String danmutime;
    /**
    * 创建时间
    */
    @ApiModelProperty("创建时间")
    private Date createtime;


}
