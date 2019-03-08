package com.spearmint.admin.controller;

import com.spearmint.admin.domain.Menu;
import com.spearmint.admin.service.MenuService;
import com.spearmint.framework.model.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/select", produces = {"application/json;charset=UTF-8"})
    public ApiResponse selectById(String menuId) {
        return ApiResponse.success(menuId);
    }

    @PostMapping(value = "/insert", consumes = "application/json", produces = {"application/json;charset=UTF-8"})
    public ApiResponse insert(@RequestBody Menu menu) {
        return ApiResponse.success();
    }

    @PostMapping(value = "/update", consumes = "application/json", produces = {"application/json;charset=UTF-8"})
    public ApiResponse update(@RequestBody Menu menu) {
        return ApiResponse.success();
    }

    @GetMapping(value = "/delete", produces = {"application/json;charset=UTF-8"})
    public ApiResponse delete(String menuIds) {
        return ApiResponse.success();
    }

    @GetMapping(value = "/nav", produces = {"application/json;charset=UTF-8"})
    public ApiResponse navMenu() {
        return ApiResponse.success();
    }

}
