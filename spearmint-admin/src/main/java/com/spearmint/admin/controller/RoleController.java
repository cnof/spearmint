package com.spearmint.admin.controller;

import com.spearmint.admin.domain.Role;
import com.spearmint.admin.service.MenuService;
import com.spearmint.admin.service.RoleService;
import com.spearmint.framework.model.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 33992
 * @date 2018/12/13 11:49
 */
@RestController
@RequestMapping("/admin/role")
public class RoleController {

    private final RoleService roleService;

    private final MenuService menuService;

    @Autowired
    public RoleController(RoleService roleService, MenuService menuService) {
        this.roleService = roleService;
        this.menuService = menuService;
    }

    @GetMapping(value = "/select", produces = {"application/json;charset=UTF-8"})
    public ApiResponse selectById(String roleId) {
        return ApiResponse.success(roleId);
    }

    @PostMapping(value = "/insert", consumes = "application/json", produces = {"application/json;charset=UTF-8"})
    public ApiResponse insert(@RequestBody Role role) {
        return ApiResponse.success();
    }

    @GetMapping(value = "/update", consumes = "application/json", produces = {"application/json;charset=UTF-8"})
    public ApiResponse update(@RequestBody Role role) {
        return ApiResponse.success();
    }

    @GetMapping(value = "/delete", produces = {"application/json;charset=UTF-8"})
    public ApiResponse delete(String roleIds) {
        return ApiResponse.success();
    }

    @GetMapping(value = "/role-has-menus", produces = {"application/json;charset=UTF-8"})
    public ApiResponse roleHasMenus(String roleId) {
        return ApiResponse.success(menuService.listRoleHasMenus(roleId));
    }
}
