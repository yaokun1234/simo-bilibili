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
* 视频标签关联表
* @TableName t_video_tag
*/
@Entity
@Table(name = "t_video_tag")
@Data
public class VideoTag implements Serializable {

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
    * 标签id
    */
    @NotNull(message="[标签id]不能为空")
    @ApiModelProperty("标签id")
    private Long tagid;
    /**
    * 创建时间
    */
    @ApiModelProperty("创建时间")
    private Date createtime;

}
