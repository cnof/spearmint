package com.spearmint.admin.security;

import com.spearmint.admin.domain.Role;
import com.spearmint.admin.domain.User;
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

    public static JwtUser create(User user, List<Role> roles) {
        return new JwtUser(
                user.getUserId(),
                user.getUsername(),
                user.getPassword(),
                user.getEnabled(),
                mapToGrantedAuthorities(roles),
                user.getLastPasswordResetDate()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getRoleName()))
                .collect(Collectors.toList());
    }
}
