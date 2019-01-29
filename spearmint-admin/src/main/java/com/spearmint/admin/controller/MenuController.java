package com.spearmint.admin.controller;

import com.spearmint.admin.domain.MenuDO;
import com.spearmint.admin.service.MenuService;
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
@RequestMapping("/admin/menu")
public class MenuController {

    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @RequestMapping(value = "/select", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public ApiResponse selectById(String menuId) {
        return ApiResponse.success(menuId);
    }

    @RequestMapping(value = "/insert", consumes = "application/json", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public ApiResponse insert(@RequestBody MenuDO menu) {
        return ApiResponse.success(menuService.insertSelective(menu));
    }

    @RequestMapping(value = "/update", consumes = "application/json", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public ApiResponse update(@RequestBody MenuDO menu) {
        return ApiResponse.success(menuService.updateSelective(menu));
    }

    @RequestMapping(value = "/delete", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public ApiResponse delete(String menuIds) {
        return ApiResponse.success(menuService.removeByIds(menuIds));
    }

    @RequestMapping(value = "/nav", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public ApiResponse navMenu() {
        return ApiResponse.success();
    }

}
