package com.simo.dao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

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
    private Instant createTime;

    @Column(name = "updateTime")
    private Instant updateTime;

}