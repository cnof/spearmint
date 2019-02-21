package com.spearmint.admin.mapper;

import com.spearmint.admin.domain.UserDO;
import com.spearmint.framework.mybatis.mapper.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dukang
 * @since 2018-10-19
 */
@Repository
public interface UserMapper extends Mapper<UserDO> {

    /**
     * find by user name
     * @param username user name
     * @return user
     */
    UserDO findByUsername(@Param("username") String username);
}
