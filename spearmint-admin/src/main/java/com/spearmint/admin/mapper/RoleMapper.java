package com.spearmint.admin.mapper;

import com.spearmint.admin.domain.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 33992
 * @date 2018/12/1 18:41
 */
@Repository
public interface RoleMapper {

    /**
     * 查询角色信息
     * @param roleIds 角色主键
     * @return 角色信息
     */
    List<Role> listRolesByRoleIds(@Param("roleIds") List<String> roleIds);
}
