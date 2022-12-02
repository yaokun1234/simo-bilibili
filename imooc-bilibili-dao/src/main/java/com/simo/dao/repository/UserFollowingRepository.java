package com.simo.dao.repository;

import com.simo.dao.entity.UserFollowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFollowingRepository extends JpaRepository<UserFollowing, String> {
    void deleteByUserIdAndFollowingId(String userId, String groupId);

    List<UserFollowing> findAllByUserId(String userId);

    List<UserFollowing> findAllByFollowingId(String userId);

    boolean existsByUserIdAndFollowingId(String userId, String userId1);
}