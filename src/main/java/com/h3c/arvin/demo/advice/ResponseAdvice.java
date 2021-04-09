package com.h3c.arvin.demo.advice;

import com.h3c.arvin.demo.annotation.IgnoreResponseAdvice;
import com.h3c.arvin.demo.result.ResultBO;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter,
                            Class<? extends HttpMessageConverter<?>> aClass) {
        if (methodParameter.getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class))
            return false;
        if (methodParameter.getMethod().isAnnotationPresent(IgnoreResponseAdvice.class))
            return false;
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter,
                                  MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        ResultBO<Object> resultBO = new ResultBO(0, "success");
        if (null == o)
            return resultBO;
        else if (o instanceof ResultBO)
            resultBO = (ResultBO<Object>) o;
        else
            resultBO.setData(o);
        return resultBO;
    }
}
