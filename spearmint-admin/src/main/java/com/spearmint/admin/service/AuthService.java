package com.spearmint.admin.service;

import com.spearmint.admin.domain.User;

/**
 * @author 33992
 * @date 2019/2/14 15:53
 */
public interface AuthService {

    /**
     * register
     * @param userToAdd user
     * @return user
     */
    User register(User userToAdd);

    /**
     * login
     * @param username username
     * @param password password
     * @return token
     */
    String login(String username, String password);

    /**
     * refresh token
     * @param oldToken old token
     * @return token
     */
    String refresh(String oldToken);
}
