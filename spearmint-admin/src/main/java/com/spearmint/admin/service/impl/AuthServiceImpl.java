package com.spearmint.admin.service.impl;

import com.spearmint.admin.domain.UserDO;
import com.spearmint.admin.security.JwtTokenUtil;
import com.spearmint.admin.security.JwtUser;
import com.spearmint.admin.service.AuthService;
import com.spearmint.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * @author 33992
 * @date 2019/2/14 15:56
 */
@Service
public class AuthServiceImpl implements AuthService {

    private UserService userService;

    private UserDetailsService userDetailsService;

    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    public AuthServiceImpl(UserService userService, @Qualifier("jwtUserDetailsServiceImpl") UserDetailsService
            userDetailsService, JwtTokenUtil jwtTokenUtil) {
        this.userService = userService;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    public UserDO register(UserDO userToAdd) {
        userService.insertSelective(userToAdd);
        return userToAdd;
    }

    @Override
    public String login(String username, String password) {

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return jwtTokenUtil.generateToken(userDetails);
    }

    @Override
    public String refresh(String oldToken) {
        String token = oldToken.substring(tokenHead.length());
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
            return jwtTokenUtil.refreshToken(token);
        }
        return null;
    }
}
