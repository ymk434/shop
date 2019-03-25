package com.httpapi.bmt.configue;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
@ControllerAdvice
public class GlobalExceptionError {
    //捕获异常错误
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Map<String,Object> exceptionHandler (Exception ex) {
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("code","500");
        result.put("msg",ex.getMessage());
        System.out.println(result);
        return result;
    }

}
