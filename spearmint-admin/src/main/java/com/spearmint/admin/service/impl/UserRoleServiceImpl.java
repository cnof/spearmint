package com.spearmint.admin.service.impl;

import com.spearmint.admin.domain.UserRoleDO;
import com.spearmint.admin.mapper.UserRoleMapper;
import com.spearmint.admin.service.UserRoleService;
import com.spearmint.framework.mybatis.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author 33992
 * @date 2018/12/13 11:46
 */
@Service
public class UserRoleServiceImpl extends BaseServiceImpl<UserRoleMapper, UserRoleDO> implements UserRoleService {

}
