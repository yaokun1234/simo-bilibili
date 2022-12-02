package com.simo.dao.repository;

import com.simo.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {


    User findOneByPhone(String phone);

    User findOneByPhoneOrEmail(String phone, String email);
}

