package com.spearmint.admin.controller;

import com.spearmint.admin.domain.RoleMenuDO;
import com.spearmint.admin.service.RoleMenuService;
import com.spearmint.admin.vo.RoleMenuVO;
import com.spearmint.framework.model.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/insert", consumes = "application/json", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public ApiResponse insert(@RequestBody RoleMenuVO roleHasMenus) {
        return ApiResponse.success(roleMenuService.addRoleHasMenus(roleHasMenus));
    }

    @RequestMapping(value = "/update", consumes = "application/json", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public ApiResponse update(@RequestBody RoleMenuDO roleMenu) {
        return ApiResponse.success(roleMenuService.updateSelective(roleMenu));
    }

    @RequestMapping(value = "/delete", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public ApiResponse delete(String roleMenuIds) {
        return ApiResponse.success(roleMenuService.removeByIds(roleMenuIds));
    }
}
