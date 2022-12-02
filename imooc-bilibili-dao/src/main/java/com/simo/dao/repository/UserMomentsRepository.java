package com.simo.dao.repository;

import com.simo.dao.entity.UserMoment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMomentsRepository extends JpaRepository<UserMoment,String> {
    List<UserMoment> findAllByUserIdIn(List<String> followingIdList);
}
