package com.simo.dao.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
* 视频收藏记录表
* @TableName t_video_collection
*/
@Entity
@Table(name = "t_video_collection")
@Data
public class VideoCollection implements Serializable {

    /**
    * 主键id
    */
    @Id
    @ApiModelProperty("主键id")
    private Long id;
    /**
    * 视频投稿id
    */
    @ApiModelProperty("视频投稿id")
    private Long videoid;
    /**
    * 用户id
    */
    @ApiModelProperty("用户id")
    private Long userid;
    /**
    * 收藏分组id
    */
    @ApiModelProperty("收藏分组id")
    private Long groupid;
    /**
    * 创建时间
    */
    @ApiModelProperty("创建时间")
    private Date createtime;


}
