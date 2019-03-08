package com.spearmint.admin.controller;

import com.spearmint.admin.domain.UserRole;
import com.spearmint.admin.service.UserRoleService;
import com.spearmint.framework.model.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 33992
 * @date 2018/12/13 11:49
 */
@RestController
@RequestMapping("/admin/user-role")
public class UserRoleController {

    private final UserRoleService userRoleService;

    @Autowired
    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @PostMapping(value = "/insert", consumes = "application/json", produces = {"application/json;charset=UTF-8"})
    public ApiResponse insert(@RequestBody UserRole userRole) {
        return ApiResponse.success();
    }

    @PostMapping(value = "/update", consumes = "application/json", produces = {"application/json;charset=UTF-8"})
    public ApiResponse update(@RequestBody UserRole userRole) {
        return ApiResponse.success();
    }

    @GetMapping(value = "/delete", produces = {"application/json;charset=UTF-8"})
    public ApiResponse delete(String userRoleIds) {
        return ApiResponse.success();
    }
}
