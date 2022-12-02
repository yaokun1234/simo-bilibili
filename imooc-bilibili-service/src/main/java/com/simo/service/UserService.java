package com.simo.service;

import com.simo.dao.constant.UserInfoConstant;
import com.simo.dao.entity.User;
import com.simo.dao.entity.UserInfo;
import com.simo.dao.exception.ConditionException;
import com.simo.dao.repository.UserInfoRepository;
import com.simo.dao.repository.UserRepository;
import com.simo.dao.repository.UserSpecificationsRepository;
import com.simo.service.util.MD5Util;
import com.simo.service.util.RSAUtil;
import com.simo.service.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserSpecificationsRepository userSpecificationsRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;

    /**
     *  添加用户
     */
    public void addUser(User user) throws Exception {
        if(!StringUtils.hasText(user.getPhone())){
            throw new ConditionException("请输入手机号");
        }else if(getUserByPhone(user.getPhone()) != null){
            throw new ConditionException("该手机号已注册");
        }else{
            String decryptPassword = RSAUtil.decrypt(user.getPassword());
            String salt =String.valueOf(System.currentTimeMillis());
            String MD5PassWord = MD5Util.sign(decryptPassword, salt, "UTF-8");
            user.setSalt(salt);
            user.setPassword(MD5PassWord);
            user.setId(UUID.randomUUID().toString());
            user.setCreateTime(new Date());
            userRepository.save(user);
            UserInfo userInfo = new UserInfo();
            userInfo.setUserId(user.getId());
            userInfo.setBirth(UserInfoConstant.DEFAULT_BIRTH);
            userInfo.setGender(UserInfoConstant.GENDER_UNKNOW);
            userInfo.setNick(UserInfoConstant.DEFAULT_NICK+UUID.randomUUID().toString().substring(10));
            userInfo.setCreateTime(new Date());
            userInfo.setId(UUID.randomUUID().toString());
            userInfoRepository.save(userInfo);
        }
    }

    /**
     *  根据phone获取用户
     */
    public User getUserByPhone(String phone){
        return userRepository.findOneByPhone(phone);
    }

    /**
     *  检查是否必须有手机号或者邮箱
     *  通过手机号和邮箱查询用户
     *  对密码进行解密然后加密后和数据库内对进行对比
     *  返回Token
     */
    public String login(User user) throws Exception {
        String phone = user.getPhone() == null ? "" : user.getPhone();
        String email = user.getEmail() == null ? "" : user.getEmail();
        if(!StringUtils.hasText(phone) && !StringUtils.hasText(email)){
            throw new ConditionException("参数异常！");
        }
        User dbUser = userRepository.findOneByPhoneOrEmail(phone,email);
        if(dbUser == null){
            throw new ConditionException("当前用户不存在！");
        }
        String password = user.getPassword();
        String rawPassword;
        try{
            rawPassword = RSAUtil.decrypt(password);
        }catch (Exception e){
            throw new ConditionException("密码解密失败！");
        }
        String salt = dbUser.getSalt();
        String md5Password = MD5Util.sign(rawPassword, salt, "UTF-8");
        if(!md5Password.equals(dbUser.getPassword())){
            throw new ConditionException("密码错误！");
        }
        return TokenUtil.generateToken(dbUser.getId());
    }

    public void updateUserById(User user) throws Exception{
        User dbUser = userRepository.getById(user.getId());
        if(dbUser == null){
            throw new ConditionException("用户不存在！");
        }
        dbUser.setUpdateTime(new Date());
        if(StringUtils.hasText(user.getEmail())){
            dbUser.setEmail(user.getEmail());
        }
        if(StringUtils.hasText(user.getPhone())){
            dbUser.setPhone(user.getPhone());
        }
        if(StringUtils.hasText(user.getPassword())){
            String rawPassword = RSAUtil.decrypt(user.getPassword());
            String md5Password = MD5Util.sign(rawPassword, dbUser.getSalt(), "UTF-8");
            dbUser.setPassword(md5Password);
        }
        userRepository.save(dbUser);
    }

    public User getById(String followingId) {
        return userRepository.getById(followingId);
    }

    public User getById2(String followingId) {
        return userRepository.getById(followingId);
    }
}
