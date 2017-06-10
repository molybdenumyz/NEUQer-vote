package com.neuqer.voter.exception;

import com.alibaba.fastjson.JSONException;
import com.neuqer.voter.common.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartException;


/**
 * Created by yinzhe on 17/5/17.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理自定义基本异常
     */

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Response handle(BaseException e) {
        return new Response(e.getCode(), e.getMessage());
    }

    /**
     * 处理框架提供的异常
     */

    @ExceptionHandler({
            MethodArgumentNotValidException.class,
            MissingPathVariableException.class,
            org.springframework.dao.DuplicateKeyException.class
    })
    @ResponseBody
    public Response handleDefaultException(Exception e) {
        return new Response(10005, e.getMessage());
    }
}
