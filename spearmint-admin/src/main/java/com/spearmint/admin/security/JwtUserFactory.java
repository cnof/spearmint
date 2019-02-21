package com.spearmint.admin.security;

import com.spearmint.admin.domain.RoleDO;
import com.spearmint.admin.domain.UserDO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dk
 */
public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(UserDO user) {
        return new JwtUser(
                user.getUserId(),
                user.getUsername(),
                user.getPassword(),
                user.getEnabled(),
                mapToGrantedAuthorities(user.getRoles()),
                user.getLastPasswordResetDate()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<RoleDO> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getRoleName()))
                .collect(Collectors.toList());
    }
}
