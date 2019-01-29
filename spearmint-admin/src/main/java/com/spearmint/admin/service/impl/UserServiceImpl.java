package com.spearmint.admin.service.impl;

import com.spearmint.admin.domain.MenuDO;
import com.spearmint.admin.domain.RoleDO;
import com.spearmint.admin.domain.UserDO;
import com.spearmint.admin.mapper.*;
import com.spearmint.admin.service.UserService;
import com.spearmint.framework.mybatis.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 33992
 * @date 2018/12/12 16:06
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, UserDO> implements UserService {

    private final RoleMenuMapper roleMenuMapper;

    private final UserRoleMapper userRoleMapper;

    private final RoleMapper roleMapper;

    private final MenuMapper menuMapper;

    @Autowired
    public UserServiceImpl(RoleMenuMapper roleMenuMapper, UserRoleMapper userRoleMapper, RoleMapper roleMapper, MenuMapper menuMapper) {
        this.roleMenuMapper = roleMenuMapper;
        this.userRoleMapper = userRoleMapper;
        this.roleMapper = roleMapper;
        this.menuMapper = menuMapper;
    }

    @Override
    public List<RoleDO> userHasRoles(String userId) {
        List<String> roleIds = userRoleMapper.listRoleIdsByUserId(userId);
        if (roleIds.isEmpty()) {
            return new ArrayList<>();
        }
        return roleMapper.listRolesByRoleIds(roleIds);
    }

    @Override
    public List<MenuDO> userHasMenus(String userId) {
        List<String> roleIds = userRoleMapper.listRoleIdsByUserId(userId);
        if (roleIds.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> menuIds = roleMenuMapper.listMenuIdsByRoleIds(roleIds);
        if (menuIds.isEmpty()) {
            return new ArrayList<>();
        }
        return menuMapper.listMenusByMenuIds(menuIds);
    }
}
