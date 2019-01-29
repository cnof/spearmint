package com.spearmint.admin.controller;

import com.spearmint.admin.domain.RoleDO;
import com.spearmint.admin.service.MenuService;
import com.spearmint.admin.service.RoleService;
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
@RequestMapping("/admin/role")
public class RoleController {

    private final RoleService roleService;

    private final MenuService menuService;

    @Autowired
    public RoleController(RoleService roleService, MenuService menuService) {
        this.roleService = roleService;
        this.menuService = menuService;
    }

    @RequestMapping(value = "/select", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public ApiResponse selectById(String roleId) {
        return ApiResponse.success(roleId);
    }

    @RequestMapping(value = "/insert", consumes = "application/json", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public ApiResponse insert(@RequestBody RoleDO role) {
        return ApiResponse.success(roleService.insertSelective(role));
    }

    @RequestMapping(value = "/update", consumes = "application/json", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public ApiResponse update(@RequestBody RoleDO role) {
        return ApiResponse.success(roleService.updateSelective(role));
    }

    @RequestMapping(value = "/delete", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public ApiResponse delete(String roleIds) {
        return ApiResponse.success(roleService.removeByIds(roleIds));
    }

    @RequestMapping(value = "/role-has-menus", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public ApiResponse roleHasMenus(String roleId) {
        return ApiResponse.success(menuService.listRoleHasMenus(roleId));
    }
}
