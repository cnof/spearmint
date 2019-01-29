package com.spearmint.framework.model;

import lombok.Data;

/**
 * @author dukang
 * @date 2018/10/25 22:23
 */
@Data
public class ApiResponse<T> {

    private static final Integer CODE_SUCCESS = 1001;

    private static final Integer CODE_FAIL = 1002;

    private Integer code;

    private String msg;

    private T data;

    private ApiResponse(Integer code) {
        this.code = code;
    }

    private ApiResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private ApiResponse(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ApiResponse success() {
        return new ApiResponse(CODE_SUCCESS);
    }

    public static ApiResponse<Object> success(Object data) {
        return new ApiResponse<>(CODE_SUCCESS, "成功", data);
    }

    public static ApiResponse fail(String msg) {
        return new ApiResponse(CODE_FAIL, msg);
    }

    public static ApiResponse fail(Integer code, String msg) {
        return new ApiResponse(code, msg);
    }

    public static ApiResponse widthCode(Integer errorCode) {
        return new ApiResponse(errorCode);
    }
}
