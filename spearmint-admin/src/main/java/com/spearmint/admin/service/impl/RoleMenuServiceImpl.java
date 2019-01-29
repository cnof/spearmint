package com.spearmint.admin.service.impl;

import com.spearmint.admin.domain.RoleMenuDO;
import com.spearmint.admin.mapper.RoleMenuMapper;
import com.spearmint.admin.service.RoleMenuService;
import com.spearmint.admin.vo.RoleMenuVO;
import com.spearmint.framework.mybatis.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author 33992
 * @date 2018/12/13 11:47
 */
@Service
public class RoleMenuServiceImpl extends BaseServiceImpl<RoleMenuMapper, RoleMenuDO> implements RoleMenuService {

    @Override
    public Boolean addRoleHasMenus(RoleMenuVO roleHasMenus) {

        for (String menuId : roleHasMenus.getMenuIds()) {
            RoleMenuDO roleMenu = new RoleMenuDO();
            roleMenu.setRoleId(roleHasMenus.getRoleId());
            roleMenu.setMenuId(menuId);
            try {
                insertSelective(roleMenu);
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }
}
