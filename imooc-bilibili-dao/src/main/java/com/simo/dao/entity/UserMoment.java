package com.simo.dao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "t_user_moments")
@Data
public class UserMoment {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "userId")
    private String userId;

    @Column(name = "type", length = 5)
    private String type;

    @Column(name = "contentId")
    private String contentId;

    @Column(name = "createTime")
    private Date createTime;

    @Column(name = "updateTime")
    private Date updateTime;

    public UserMoment() {
        this.id = UUID.randomUUID().toString();
        this.createTime = new Date();
        this.updateTime = new Date();
    }

}