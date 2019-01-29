package com.spearmint.admin.controller;

import com.spearmint.admin.domain.UserDO;
import com.spearmint.admin.service.UserService;
import com.spearmint.framework.model.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/select", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public ApiResponse select(String userId) {
        return ApiResponse.success((userId));
    }

    @RequestMapping(value = "/insert", consumes = "application/json", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public ApiResponse insert(@RequestBody UserDO user) {
        return ApiResponse.success(userService.insertSelective(user));
    }

    @RequestMapping(value = "/update", consumes = "application/json", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public ApiResponse update(@RequestBody UserDO user) {
        return ApiResponse.success(userService.updateSelective(user));
    }

    @RequestMapping(value = "/delete", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public ApiResponse delete(String userIds) {
        return ApiResponse.success(userService.removeByIds(userIds));
    }

    @RequestMapping(value = "/user-has-roles", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public ApiResponse userHasRoles(String userId) {
        return ApiResponse.success(userService.userHasRoles(userId));
    }

    @RequestMapping(value = "/user-has-menus", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public ApiResponse userHasMenus(String userId) {
        return ApiResponse.success(userService.userHasMenus(userId));
    }
}
