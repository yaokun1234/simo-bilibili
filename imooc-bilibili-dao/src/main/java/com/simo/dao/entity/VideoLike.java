package com.simo.dao.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
* 视频点赞记录表
* @TableName t_video_like
*/
@Entity
@Table(name = "t_video_like")
@Data
public class VideoLike implements Serializable {

    /**
    * 主键id
    */
    @Id
    @ApiModelProperty("主键id")
    private Long id;
    /**
    * 用户id
    */
    @NotNull(message="[用户id]不能为空")
    @ApiModelProperty("用户id")
    private Long userid;
    /**
    * 视频投稿id
    */
    @NotNull(message="[视频投稿id]不能为空")
    @ApiModelProperty("视频投稿id")
    private Long videoid;
    /**
    * 创建时间
    */
    @ApiModelProperty("创建时间")
    private Date createtime;


}
