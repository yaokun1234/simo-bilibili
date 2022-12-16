package com.simo.dao.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
* 视频评论表
* @TableName t_video_comment
*/
@Entity
@Table(name = "t_video_comment")
@Data
public class VideoComment implements Serializable {

    /**
    * 主键id
    */
    @Id
    @ApiModelProperty("主键id")
    private Long id;
    /**
    * 视频id
    */
    @NotNull(message="[视频id]不能为空")
    @ApiModelProperty("视频id")
    private Long videoid;
    /**
    * 用户id
    */
    @NotNull(message="[用户id]不能为空")
    @ApiModelProperty("用户id")
    private Long userid;
    /**
    * 评论
    */
    @NotBlank(message="[评论]不能为空")
    
    @ApiModelProperty("评论")
    private String comment;
    /**
    * 回复用户id
    */
    @ApiModelProperty("回复用户id")
    private Long replyuserid;
    /**
    * 根节点评论id
    */
    @ApiModelProperty("根节点评论id")
    private Long rootid;
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
