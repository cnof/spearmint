package com.spearmint.admin.mapper;

import com.spearmint.admin.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dukang
 * @since 2018-10-19
 */
@Repository
public interface UserMapper {

    /**
     * find by user name
     * @param username user name
     * @return user
     */
    User findByUsername(@Param("username") String username);
}
