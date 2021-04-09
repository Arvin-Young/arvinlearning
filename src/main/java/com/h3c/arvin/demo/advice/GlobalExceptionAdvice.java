package com.h3c.arvin.demo.advice;

import com.h3c.arvin.demo.exception.AdException;
import com.h3c.arvin.demo.result.ResultBO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionAdvice {
    @ExceptionHandler(AdException.class)
    public ResultBO<String> handleAdException(HttpServletRequest req,
                                              AdException e) {
        ResultBO<String> resultBO = new ResultBO<>(-1, "server error");
        resultBO.setData(e.getMessage());
        return resultBO;
    }
}
