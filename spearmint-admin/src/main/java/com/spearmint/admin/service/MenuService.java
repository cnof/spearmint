package com.spearmint.admin.service;


import com.spearmint.admin.domain.Menu;

import java.util.List;

/**
 * @author 33992
 * @date 2018/12/13 09:04
 */
public interface MenuService {

    /**
     * list role has menus
     * @param roleId role primary key
     * @return menus
     */
    List<Menu> listRoleHasMenus(String roleId);
}
