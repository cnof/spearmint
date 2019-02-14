package com.spearmint.admin.component;

import com.spearmint.framework.jwt.JwtUser;
import com.spearmint.framework.jwt.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 33992
 * @date 2019/2/13 17:22
 */
@Component
public class JwtTokenUtil implements Serializable {

    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    public String getUsernameFromToken(String token) {
        String username;

        try {
            Claims claims = JwtUtils.getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }

        return username;
    }

    private Date getCreatedDateFromToken(String token) {
        Date created;
        try {
            Claims claims = JwtUtils.getClaimsFromToken(token);
            created = new Date((Long) claims.get(CLAIM_KEY_CREATED));
        } catch (Exception e) {
            created = null;
        }
        return created;
    }

    private Date getExpirationDateFromToken(String token) {
        Date expirationDate;
        try {
            final Claims claims = JwtUtils.getClaimsFromToken(token);
            expirationDate = claims.getExpiration();
        } catch (Exception e) {
            expirationDate = null;
        }
        return expirationDate;
    }

    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 100);
    }

    private Boolean isTokenExpired(String token) {
        Date expirationDate = getExpirationDateFromToken(token);
        return expirationDate != null && expirationDate.before(new Date());
    }

    private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
        return lastPasswordReset != null && created.before(lastPasswordReset);
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>(2);
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED, new Date());
        return JwtUtils.generateToken(claims, secret, generateExpirationDate());
    }

    public Boolean canTokenBeRefreshed(String token, Date lastPasswordReset) {
        Date created = getCreatedDateFromToken(token);
        return !isCreatedBeforeLastPasswordReset(created, lastPasswordReset) && !isTokenExpired(token);
    }

    public String refreshToken(String token) {
        String refreshedToken;
        try {
            Claims claims = JwtUtils.getClaimsFromToken(token);
            claims.put(CLAIM_KEY_CREATED, new Date());
            refreshedToken = JwtUtils.generateToken(claims, secret, generateExpirationDate());
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        JwtUser user = (JwtUser) userDetails;
        String username = getUsernameFromToken(token);
        Date created = getCreatedDateFromToken(token);
        return (username != null && username.equals(user.getUsername())) && !isTokenExpired(token)
                && !isCreatedBeforeLastPasswordReset(created, user.getLastPasswordResetDate());
    }
}
