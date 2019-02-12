package com.spearmint.admin.utils;

import com.spearmint.admin.domain.UserDO;
import com.spearmint.framework.jwt.JwtUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 33992
 * @date 2019/1/29 16:40
 */
public class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(UserDO user, List<String> roles) {
        return new JwtUser(
                user.getUsername(),
                user.getPassword(),
                mapToGrantedAuthorities(roles)
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> roles) {
        return roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }
}
