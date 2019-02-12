package com.spearmint.admin.controller;

import com.spearmint.admin.domain.UserDO;
import com.spearmint.admin.service.UserService;
import com.spearmint.framework.model.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 33992
 * @date 2018/12/12 16:10
 */
@RestController
@RequestMapping(value = "/admin/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/select", produces = {"application/json;charset=UTF-8"})
    public ApiResponse select(String userId) {
        return ApiResponse.success((userId));
    }

    @PostMapping(value = "/insert", consumes = "application/json", produces = {"application/json;charset=UTF-8"})
    public ApiResponse insert(@RequestBody UserDO user) {
        return ApiResponse.success(userService.insertSelective(user));
    }

    @PostMapping(value = "/update", consumes = "application/json", produces = {"application/json;charset=UTF-8"})
    public ApiResponse update(@RequestBody UserDO user) {
        return ApiResponse.success(userService.updateSelective(user));
    }

    @GetMapping(value = "/delete", produces = {"application/json;charset=UTF-8"})
    public ApiResponse delete(String userIds) {
        return ApiResponse.success(userService.removeByIds(userIds));
    }

    @GetMapping(value = "/user-has-roles", produces = {"application/json;charset=UTF-8"})
    public ApiResponse userHasRoles(String userId) {
        return ApiResponse.success(userService.userHasRoles(userId));
    }

    @GetMapping(value = "/user-has-menus", produces = {"application/json;charset=UTF-8"})
    public ApiResponse userHasMenus(String userId) {
        return ApiResponse.success(userService.userHasMenus(userId));
    }
}
