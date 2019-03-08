package com.spearmint.admin.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 33992
 * @date 2018/12/1 19:48
 */
@Data
@TableName("admin_role_menu")
public class RoleMenu implements Serializable {

    @TableId(value = "role_menu_id", type = IdType.UUID)
    private String roleMenuId;

    private String roleId;

    private String menuId;
}
