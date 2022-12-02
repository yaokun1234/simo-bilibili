package com.simo.dao.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_user_info")
@Data
public class UserInfo {

    @Id
    private String id;

    private String userId;

    private String nick;

    private String avatar;

    private String sign;

    private String gender;

    private String birth;

    @Column(name = "createTime")
    private Date createTime;

    @Column(name = "updateTime")
    private Date updateTime;

    @Transient
    private Boolean followed;
}
