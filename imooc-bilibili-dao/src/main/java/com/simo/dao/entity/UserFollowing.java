package com.simo.dao.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Entity
@Table(name = "t_user_following")
@Data
@ApiModel(description = "用户关注")
public class UserFollowing {

    @Id
    @ApiModelProperty(value = "唯一值")
    private String id;

    @ApiModelProperty(value = "用户Id")
    private String userId;

    @ApiModelProperty(value = "被关注用户Id")
    private String followingId;

    @ApiModelProperty(value = "关注分组id")
    private String groupId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @Transient
    @ApiModelProperty(value = "用户信息")
    private UserInfo userInfo;


}
