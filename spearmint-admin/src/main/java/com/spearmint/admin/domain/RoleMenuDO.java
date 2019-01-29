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
 * @date 2018/12/1 19:48
 */
@Data
@TableName("admin_role_menu")
@EqualsAndHashCode(callSuper = true)
public class RoleMenuDO extends CommonEntity implements Serializable {

    @TableId(value = "role_menu_id", type = IdType.UUID)
    private String roleMenuId;

    private String roleId;

    private String menuId;
}
