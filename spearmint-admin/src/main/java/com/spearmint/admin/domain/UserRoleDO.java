package com.spearmint.admin.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.spearmint.framework.mybatis.pojo.CommonEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author 33992
 * @date 2018/12/1 18:40
 */
@Data
@TableName("admin_user_role")
@EqualsAndHashCode(callSuper = true)
public class UserRoleDO extends CommonEntity implements Serializable {

    @TableId(value = "user_role_id", type = IdType.UUID)
    private String userRoleId;

    private String roleId;

    private String userId;
}
