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
* 视频投稿记录表
* @TableName t_video
*/
@Entity
@Table(name = "t_video")
@Data
public class Video implements Serializable {

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
    * 视频链接
    */
    @NotBlank(message="[视频链接]不能为空")
    
    @ApiModelProperty("视频链接")
    private String url;
    /**
    * 封面链接
    */
    @NotBlank(message="[封面链接]不能为空")
    
    @ApiModelProperty("封面链接")
    private String thumbnail;
    /**
    * 视频标题
    */
    @NotBlank(message="[视频标题]不能为空")
    
    @ApiModelProperty("视频标题")
    private String title;
    /**
    * 视频类型：0原创 1转载
    */
    @NotBlank(message="[视频类型：0原创 1转载]不能为空")
    
    @ApiModelProperty("视频类型：0原创 1转载")
    private String type;
    /**
    * 视频时长
    */
    @NotBlank(message="[视频时长]不能为空")
    
    @ApiModelProperty("视频时长")
    private String duration;
    /**
    * 所在分区：0鬼畜 1音乐 2电影
    */
    @NotBlank(message="[所在分区：0鬼畜 1音乐 2电影]不能为空")
    
    @ApiModelProperty("所在分区：0鬼畜 1音乐 2电影")
    private String area;
    /**
    * 视频简介
    */
    
    @ApiModelProperty("视频简介")
    private String description;
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
