package com.spearmint.admin.service.impl;

import com.spearmint.admin.service.RoleMenuService;
import com.spearmint.admin.vo.RoleMenuVO;
import org.springframework.stereotype.Service;

/**
 * @author 33992
 * @date 2018/12/13 11:47
 */
@Service
public class RoleMenuServiceImpl implements RoleMenuService {

    @Override
    public Boolean addRoleHasMenus(RoleMenuVO roleHasMenus) {
        return true;
    }
}
