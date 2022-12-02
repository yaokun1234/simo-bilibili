package com.simo.dao.repository;

import com.simo.dao.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,String> {

    UserInfo findByUserId(String currentUserId);

    //void saveByUserId(UserInfo userInfo);
}
