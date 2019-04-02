package com.boot.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理异常
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Map exceptionHandler(Exception ex){
        logger.error("请求失败",ex.getLocalizedMessage(),ex);
        Map<String,Object> result = new HashMap<>();
        result.put("code",500);
        result.put("msg","请求失败");
        return result;
    }

    /**
     * 处理Spring内部异常
     * @param ex
     * @param body
     * @param headers
     * @param status
     * @param request
     * @return
     */
    protected ResponseEntity<Object> handleExceptionInternal(
            Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.info("服务器端响应失败,status : {},ex : {}",status.getReasonPhrase(),ex);
        Map<String,Object> result = new HashMap<>();
        result.put("code",status.value());
        result.put("msg",ex.getLocalizedMessage());
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
