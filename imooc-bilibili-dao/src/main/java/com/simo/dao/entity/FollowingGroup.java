package com.simo.dao.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_following_group")
@Data
public class FollowingGroup {

    @Id
    private String id;

    private String userId;

    private String name;

    private String type;

    private Date createTime;

    private Date updateTime;

    @Transient
    private List<UserInfo> followingUserInfoList;

}
