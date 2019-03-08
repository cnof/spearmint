package com.spearmint.admin.service;

import com.spearmint.admin.vo.RoleMenuVO;

/**
 * @author 33992
 * @date 2018/12/13 11:47
 */
public interface RoleMenuService {

    /**
     * 为角色新增菜单
     * @param roleHasMenus 参数
     * @return 是否成功
     */
    Boolean addRoleHasMenus(RoleMenuVO roleHasMenus);
}
