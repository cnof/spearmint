package com.spearmint.admin.mapper;

import com.spearmint.admin.domain.UserDO;
import com.spearmint.framework.mybatis.mapper.Mapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dukang
 * @since 2018-10-19
 */
@Repository
public interface UserMapper extends Mapper<UserDO> {
}
