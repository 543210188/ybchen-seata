package com.ybchen.exception;

import lombok.Data;

/**
 * 业务异常类
 * @author: chenyanbin 2022-10-24 09:14
 */
@Data
public class BizException extends RuntimeException {
    private int code;
    private String message;

    public BizException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}