package com.spearmint.admin.service.impl;

import com.spearmint.admin.domain.RoleDO;
import com.spearmint.admin.mapper.RoleMapper;
import com.spearmint.admin.service.RoleService;
import com.spearmint.framework.mybatis.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author 33992
 * @date 2018/12/13 08:43
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<RoleMapper, RoleDO> implements RoleService {
}
