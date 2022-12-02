package com.simo.dao.exception;

import lombok.Data;

@Data
public class ConditionException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private String code;

    public ConditionException(String message, String code) {
        super(message);
        this.code = code;
    }

    public ConditionException(String message) {
        super(message);
        this.code = "500";
    }
}
