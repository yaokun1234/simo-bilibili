package com.simo.dao.repository;

import com.simo.dao.entity.Danmu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DanmuRepository extends JpaRepository<Danmu, Long> {
}