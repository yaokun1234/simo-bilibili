package com.simo.dao.repository;

import com.simo.dao.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {

    File findByMd5(String md5);
}