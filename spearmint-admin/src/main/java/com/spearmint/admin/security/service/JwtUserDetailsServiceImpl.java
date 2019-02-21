package com.spearmint.admin.security.service;

import com.spearmint.admin.domain.UserDO;
import com.spearmint.admin.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author 33992
 * @date 2019/2/19 15:39
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    private final UserMapper userMapper;

    @Autowired
    public JwtUserDetailsServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserDO user = userMapper.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        }
        return null;
    }
}
