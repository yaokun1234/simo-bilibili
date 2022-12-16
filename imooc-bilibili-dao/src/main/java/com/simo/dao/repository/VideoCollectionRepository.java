package com.simo.dao.repository;

import com.simo.dao.entity.VideoCollection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoCollectionRepository extends JpaRepository<VideoCollection, Long> {
}