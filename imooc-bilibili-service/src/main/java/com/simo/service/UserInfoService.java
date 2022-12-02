package com.simo.service;

import com.simo.dao.entity.User;
import com.simo.dao.entity.UserInfo;
import com.simo.dao.exception.ConditionException;
import com.simo.dao.repository.UserInfoRepository;
import com.simo.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.Optional;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private UserRepository userRepository;

    public User getUserInfo(String currentUserId) {
        Optional<User> optionalUser = userRepository.findById(currentUserId);
        User user = optionalUser.orElse(null);
        if (user == null) {
            throw new ConditionException("用户不存在");
        }else{
            UserInfo userInfo = userInfoRepository.findByUserId(currentUserId);
            user.setUserInfo(userInfo);
            return user;
        }
    }

    public void updateUserByUserId(UserInfo userInfo) {
        userInfo.setUpdateTime(new Date());
        UserInfo dbUserInfo = userInfoRepository.findByUserId(userInfo.getUserId());
        if(dbUserInfo == null){
            throw new ConditionException("用户不存在");
        }

        dbUserInfo.setUpdateTime(new Date());
        if(StringUtils.hasText(userInfo.getAvatar())){
            dbUserInfo.setAvatar(userInfo.getAvatar());
        }
        if(StringUtils.hasText(userInfo.getBirth())){
            dbUserInfo.setBirth(userInfo.getBirth());
        }
        if(StringUtils.hasText(userInfo.getGender())){
            dbUserInfo.setGender(userInfo.getGender());
        }
        if(StringUtils.hasText(userInfo.getNick())){
            dbUserInfo.setNick(userInfo.getNick());
        }
        if(StringUtils.hasText(userInfo.getSign())){
            dbUserInfo.setSign(userInfo.getSign());
        }
        userInfoRepository.save(dbUserInfo);
    }
}
