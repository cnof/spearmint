package com.spearmint.admin.service;


import com.spearmint.admin.domain.MenuDO;
import com.spearmint.framework.mybatis.service.BaseService;

import java.util.List;

/**
 * @author 33992
 * @date 2018/12/13 09:04
 */
public interface MenuService extends BaseService<MenuDO> {

    /**
     * list role has menus
     * @param roleId role primary key
     * @return menus
     */
    List<MenuDO> listRoleHasMenus(String roleId);
}
