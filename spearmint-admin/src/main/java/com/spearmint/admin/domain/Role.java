package com.spearmint.admin.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 33992
 * @date 2018/12/1 18:36
 */
@Data
@TableName("admin_role")
public class Role implements Serializable {

    @TableId(value = "role_id", type = IdType.UUID)
    private String roleId;

    private String roleCode;

    private String roleName;
}