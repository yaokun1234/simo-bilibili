package com.simo.dao.repository;

import com.simo.dao.entity.FollowingGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface FollowingGroupRepository extends JpaRepository<FollowingGroup, String> {

    FollowingGroup findByType(String type);

    List<FollowingGroup> findByUserId(String userId);

    List<FollowingGroup> findByUserIdOrTypeIn(String userId, ArrayList<String> typeList);
}