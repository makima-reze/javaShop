package com.example.mall.product.exception;

import com.example.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dai17
 * @create 2022-09-18 20:41
 */
@Slf4j
@RestControllerAdvice(basePackages = "com.example.mall.product.controller")
public class MallExceptionControllerAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R HandleValidException(MethodArgumentNotValidException e){
        log.error("校验异常：",e.getMessage());
        BindingResult bindingResult = e.getBindingResult();
        Map<String,String> errorMap = new HashMap<>();
        bindingResult.getFieldErrors().forEach((fieldError)->{
            errorMap.put(fieldError.getField(),fieldError.getDefaultMessage());
        });
        return R.error(400,"数据校验问题").put("data",errorMap);
    }

}
