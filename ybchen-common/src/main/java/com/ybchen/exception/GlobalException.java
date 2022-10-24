package com.ybchen.exception;

import com.ybchen.util.ReturnT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 * @author: chenyanbin 2022-10-21 15:43
 */
@RestControllerAdvice
@Slf4j
public class GlobalException {
    @ExceptionHandler(Exception.class)
    public ReturnT<String> exception(Exception e) {
        log.error("全局异常：{}", e);
        return ReturnT.buildError("发现未知错误，请联系管理员，错误信息:" + e);
    }
}
