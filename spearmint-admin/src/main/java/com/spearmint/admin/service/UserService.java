package com.spearmint.admin.service;

import com.spearmint.admin.domain.Menu;
import com.spearmint.admin.domain.Role;

import java.util.List;

/**
 * @author 33992
 * @date 2018/12/12 16:04
 */
public interface UserService {

    /**
     * 用户拥有的角色
     * @param userId 用户主键
     * @return 角色信息
     */
    List<Role> userHasRoles(String userId);

    /**
     * 用户拥有的菜单
     * @param userId 用户主键
     * @return 菜单信息
     */
    List<Menu> userHasMenus(String userId);
}
