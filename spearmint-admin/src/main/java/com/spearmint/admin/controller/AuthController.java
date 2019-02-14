package com.spearmint.admin.controller;

import com.spearmint.admin.domain.UserDO;
import com.spearmint.admin.service.AuthService;
import com.spearmint.framework.model.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 33992
 * @date 2019/2/14 16:11
 */
@RestController
public class AuthController {

    @Value("${jwt.header}")
    private String tokenHeader;

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "/auth/login", consumes = "application/json")
    public ApiResponse createToken(String username, String password) {
        String token = authService.login(username, password);
        return ApiResponse.success(token);
    }

    @GetMapping(value = "/auth/refresh")
    public ApiResponse refreshToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshedToken = authService.refresh(token);
        return ApiResponse.success(refreshedToken);
    }

    @PostMapping(value = "/auth/register", consumes = "application/json")
    public ApiResponse register(@RequestBody UserDO addedUser) {
        return ApiResponse.success(authService.register(addedUser));
    }
}
