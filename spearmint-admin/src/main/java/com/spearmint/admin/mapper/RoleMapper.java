package com.spearmint.admin.mapper;

import com.spearmint.admin.domain.RoleDO;
import com.spearmint.framework.mybatis.mapper.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 33992
 * @date 2018/12/1 18:41
 */
@Repository
public interface RoleMapper extends Mapper<RoleDO> {

    /**
     * 查询角色信息
     * @param roleIds 角色主键
     * @return 角色信息
     */
    List<RoleDO> listRolesByRoleIds(@Param("roleIds") List<String> roleIds);
}
