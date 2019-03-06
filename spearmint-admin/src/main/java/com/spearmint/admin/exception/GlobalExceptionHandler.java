package com.spearmint.admin.exception;

import com.spearmint.framework.model.ApiResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 33992
 * @date 2019/2/22 15:36
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ApiResponse globalException(Exception ex) {
        return ApiResponse.fail(1002, ex.getMessage());
    }
}
