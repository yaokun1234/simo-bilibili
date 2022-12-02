package com.simo.dao.repository;

import com.simo.dao.entity.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserSpecificationsRepository
        extends PagingAndSortingRepository<User,String>, JpaSpecificationExecutor<User> {
}
