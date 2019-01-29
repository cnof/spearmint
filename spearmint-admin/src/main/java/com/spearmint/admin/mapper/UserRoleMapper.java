package com.spearmint.admin.mapper;

import com.spearmint.admin.domain.UserRoleDO;
import com.spearmint.framework.mybatis.mapper.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 33992
 * @date 2018/12/1 18:42
 */
@Repository
public interface UserRoleMapper extends Mapper<UserRoleDO> {

    /**
     * 根据用户编码查询角色编码
     * @param userId 用户编码
     * @return 角色编码
     */
    List<String> listRoleIdsByUserId(String userId);

    /**
     * 根据角色编码查询用户编码
     * @param roleId 角色编码
     * @return 用户编码
     */
    List<String> listUserIdByRoleId(String roleId);

    /**
     * 删除用户的角色
     * @param userId 用户编码
     * @return 影响条数
     */
    Integer removeByUserId(String userId);

    /**
     * 删除角色下的用户
     * @param roleId 角色
     * @return 影响条数
     */
    Integer removeByRoleId(String roleId);

    /**
     * 批量删除用户
     * @param userIds 用户编码
     * @return 影响条数
     */
    Integer batchRemoveByUserIds(String[] userIds);
}
