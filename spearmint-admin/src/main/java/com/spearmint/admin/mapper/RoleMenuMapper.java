package com.spearmint.admin.mapper;

import com.spearmint.admin.domain.RoleMenuDO;
import com.spearmint.framework.mybatis.mapper.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 33992
 * @date 2018/12/1 19:50
 */
@Repository
public interface RoleMenuMapper extends Mapper<RoleMenuDO> {

    /**
     * 查询角色所拥有的菜单权限
     * @param roleId 角色编码
     * @return 菜单编码
     */
    List<String> listMenuIdsByRoleId(@Param("roleId") String roleId);

    /**
     * 查询角色所拥有的菜单权限
     * @param roleIds 角色编码
     * @return 菜单编码
     */
    List<String> listMenuIdsByRoleIds(@Param("roleIds") List<String> roleIds);

    /**
     * 根据角色编码删除角色的菜单权限
     * @param roleId 角色编码
     * @return 影响条数
     */
    Integer removeByRoleId(String roleId);
}
