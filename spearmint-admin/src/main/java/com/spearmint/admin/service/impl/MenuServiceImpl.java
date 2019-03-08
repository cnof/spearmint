package com.spearmint.admin.service.impl;

import com.spearmint.admin.domain.Menu;
import com.spearmint.admin.mapper.MenuMapper;
import com.spearmint.admin.mapper.RoleMenuMapper;
import com.spearmint.admin.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 33992
 * @date 2018/12/13 09:04
 */
@Service
public class MenuServiceImpl implements MenuService {

    private final MenuMapper menuMapper;

    private final RoleMenuMapper roleMenuMapper;

    public MenuServiceImpl(MenuMapper menuMapper, RoleMenuMapper roleMenuMapper) {
        this.menuMapper = menuMapper;
        this.roleMenuMapper = roleMenuMapper;
    }

    @Override
    public List<Menu> listRoleHasMenus(String roleId) {
        List<String> menuIds = roleMenuMapper.listMenuIdsByRoleId(roleId);
        if (menuIds.isEmpty()) {
            return new ArrayList<>();
        }
        return menuMapper.listMenusByMenuIds(menuIds);
    }
}
