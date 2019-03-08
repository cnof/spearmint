package com.spearmint.admin.controller;

import com.spearmint.admin.domain.RoleMenu;
import com.spearmint.admin.service.RoleMenuService;
import com.spearmint.admin.vo.RoleMenuVO;
import com.spearmint.framework.model.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 33992
 * @date 2018/12/13 11:50
 */
@RestController
@RequestMapping("/admin/role-menu")
public class RoleMenuController {

    private final RoleMenuService roleMenuService;

    @Autowired
    public RoleMenuController(RoleMenuService roleMenuService) {
        this.roleMenuService = roleMenuService;
    }

    @PostMapping(value = "/insert", consumes = "application/json", produces = {"application/json;charset=UTF-8"})
    public ApiResponse insert(@RequestBody RoleMenuVO roleHasMenus) {
        return ApiResponse.success(roleMenuService.addRoleHasMenus(roleHasMenus));
    }

    @PostMapping(value = "/update", consumes = "application/json", produces = {"application/json;charset=UTF-8"})
    public ApiResponse update(@RequestBody RoleMenu roleMenu) {
        return ApiResponse.success();
    }

    @GetMapping(value = "/delete", produces = {"application/json;charset=UTF-8"})
    public ApiResponse delete(String roleMenuIds) {
        return ApiResponse.success();
    }
}
