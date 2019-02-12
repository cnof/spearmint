package com.spearmint.admin.service.impl;

import com.spearmint.admin.domain.UserDO;
import com.spearmint.admin.mapper.UserMapper;
import com.spearmint.admin.mapper.UserRoleMapper;
import com.spearmint.admin.utils.JwtUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author 33992
 * @date 2019/1/29 17:28
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    private final UserMapper userMapper;

    private final UserRoleMapper userRoleMapper;

    @Autowired
    public JwtUserDetailsServiceImpl(UserMapper userMapper, UserRoleMapper userRoleMapper) {
        this.userMapper = userMapper;
        this.userRoleMapper = userRoleMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserDO user = userMapper.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        }
        return JwtUserFactory.create(user, userRoleMapper.listRoleIdsByUserId(user.getUserId()));
    }
}
