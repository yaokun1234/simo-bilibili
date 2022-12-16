package com.simo.api;

import com.simo.api.support.UserSupport;
import com.simo.dao.entity.RespBean;
import com.simo.dao.entity.User;
import com.simo.dao.entity.UserInfo;
import com.simo.dao.exception.ConditionException;
import com.simo.service.UserInfoService;
import com.simo.service.UserService;
import com.simo.service.util.RSAUtil;
import com.simo.service.util.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@Api(description = "用户接口")
public class UserApi {

    @Autowired
    private UserService userService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserSupport userSupport;

    @GetMapping("/rsa-pks")
    @ApiOperation("获取RSA公钥")
    public RespBean getRsaPublicKey() throws Exception {
        String publicKey = RSAUtil.getPublicKeyStr();
        return RespBean.success("成功",publicKey);
    }

    //注册
    @PostMapping("/users")
    @ApiOperation("注册用户")
    @Transactional
    public RespBean addUser(@RequestBody User user) throws Exception {

        userService.addUser(user);
        return RespBean.success("注册成功");
    }

    @PostMapping("/user-tokens")
    @ApiOperation("用户登陆")
    @Transactional
    public RespBean login(@RequestBody User user) throws Exception {

        String token = userService.login(user);
        return RespBean.success(token);
    }

    @GetMapping("/token")
    @ApiOperation("获取Token")
    public RespBean getToken(@RequestBody User user) throws Exception {
        if(StringUtils.hasText(user.getId())){
            String token = TokenUtil.generateToken(user.getId());
            return RespBean.success(token);
        }else{
            throw new ConditionException("UserId为空");
        }
    }


    @GetMapping("/user-dts")
    public RespBean loginForDts(@RequestBody User user){
        Map token = null;
        try {
            token = userService.loginForDts(user);
        } catch (Exception e) {
            throw new ConditionException("登陆异常");
        }
        return RespBean.success(token) ;
    }

    @DeleteMapping("/refresh-tokens")
    public RespBean logout(HttpServletRequest request){
        String refreshToken = request.getHeader("refreshToken");
        String userId = userSupport.getCurrentUserId();
        userService.logout(refreshToken, userId);
        return RespBean.success();
    }

    @PostMapping("/access-tokens")
    public RespBean refreshAccessToken(HttpServletRequest request) {
        String refreshToken = request.getHeader("refreshToken");
        String accessToken = null;
        try {
            accessToken = userService.refreshAccessToken(refreshToken);
        } catch (Exception e) {
            throw new ConditionException(e.getMessage());
        }
        return RespBean.success(accessToken);
    }

    @GetMapping("/user-support")
    @ApiOperation("获取Userid")
    public RespBean getUserId(){
        String currentUserId = userSupport.getCurrentUserId();
        return RespBean.success(currentUserId);
    }

    @GetMapping("/user-info")
    @ApiOperation("获取UserInfo")
    public RespBean getUserInfo(){
        String currentUserId = userSupport.getCurrentUserId();
        User user = userInfoService.getUserInfo(currentUserId);
        return RespBean.success(user);
    }

    @PutMapping("/users")
    @ApiOperation("更新用户")
    public RespBean updateUser(@RequestBody User user) throws Exception {
        String currentUserId = userSupport.getCurrentUserId();
        user.setId(currentUserId);
        userService.updateUserById(user);
        return RespBean.success("更新成功");
    }

    @PutMapping("/user-infos")
    @ApiOperation("更新用户")
    public RespBean updateUserInfo(@RequestBody UserInfo userInfo){
        String currentUserId = userSupport.getCurrentUserId();
        userInfo.setUserId(currentUserId);
        userInfoService.updateUserByUserId(userInfo);
        return RespBean.success("更新成功");
    }

    @PutMapping("/test")
    @ApiOperation("test")
    public User test(@RequestBody UserInfo userInfo){

        return new User();
    }



}
