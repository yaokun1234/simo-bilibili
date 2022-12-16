package com.simo.service.config.handler;

import com.simo.dao.entity.RespBean;
import com.simo.dao.exception.ConditionException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CommonGlobalExceptionHandler {

    @ExceptionHandler(ConditionException.class)
    @ResponseBody
    public RespBean commonExceptionHandler(HttpServletRequest request, Exception e){
        String message = e.getMessage();
        if(e instanceof ConditionException){
            String code = ((ConditionException) e).getCode();
            return new RespBean(code,message);
        }else {
            return new RespBean("500", message);
        }
    }
}
