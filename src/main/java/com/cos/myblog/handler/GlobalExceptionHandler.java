package com.cos.myblog.handler;

import com.cos.myblog.DTO.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseDto<String> handleArgumentException(IllegalArgumentException e)
    {
       return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }
}
