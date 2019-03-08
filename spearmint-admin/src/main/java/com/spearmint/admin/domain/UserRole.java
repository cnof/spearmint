package com.spearmint.admin.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 33992
 * @date 2018/12/1 18:40
 */
@Data
@TableName("admin_user_role")
public class UserRole implements Serializable {

    @TableId(value = "user_role_id", type = IdType.UUID)
    private String userRoleId;

    private String roleId;

    private String userId;
}
