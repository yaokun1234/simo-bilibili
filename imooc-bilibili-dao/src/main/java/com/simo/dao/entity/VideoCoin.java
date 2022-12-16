package com.simo.dao.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
* 视频硬币表
* @TableName t_video_coin
*/
@Entity
@Table(name = "t_video_coin")
@Data
public class VideoCoin implements Serializable {

    /**
    * 视频投稿id
    */
    @Id
    @ApiModelProperty("视频投稿id")
    private Long id;
    /**
    * 用户id
    */
    @ApiModelProperty("用户id")
    private Long userid;
    /**
    * 视频投稿id
    */
    @ApiModelProperty("视频投稿id")
    private Long videoid;
    /**
    * 投币数
    */
    @ApiModelProperty("投币数")
    private Integer amount;
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
