package com.simo.api.support;

import com.simo.service.util.TokenUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class UserSupport {

    public String getCurrentUserId() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        String token = requestAttributes.getRequest().getHeader("token");
        return TokenUtil.verifyToken(token);
    }
}
