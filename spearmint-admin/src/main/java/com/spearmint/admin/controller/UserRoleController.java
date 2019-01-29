package com.spearmint.admin.controller;

import com.spearmint.admin.domain.UserRoleDO;
import com.spearmint.admin.service.UserRoleService;
import com.spearmint.framework.model.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/insert", consumes = "application/json", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public ApiResponse insert(@RequestBody UserRoleDO userRole) {
        return ApiResponse.success(userRoleService.insertSelective(userRole));
    }

    @RequestMapping(value = "/update", consumes = "application/json", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public ApiResponse update(@RequestBody UserRoleDO userRole) {
        return ApiResponse.success(userRoleService.updateSelective(userRole));
    }

    @RequestMapping(value = "/delete", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public ApiResponse delete(String userRoleIds) {
        return ApiResponse.success(userRoleService.removeByIds(userRoleIds));
    }
}
