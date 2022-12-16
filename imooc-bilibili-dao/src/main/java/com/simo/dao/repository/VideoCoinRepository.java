package com.simo.dao.repository;

import com.simo.dao.entity.VideoCoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoCoinRepository extends JpaRepository<VideoCoin, Long> {
}