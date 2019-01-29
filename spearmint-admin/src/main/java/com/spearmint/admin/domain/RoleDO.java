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
 * @date 2018/12/1 18:36
 */
@Data
@TableName("admin_role")
@EqualsAndHashCode(callSuper = true)
public class RoleDO extends CommonEntity implements Serializable {

    @TableId(value = "role_id", type = IdType.UUID)
    private String roleId;

    private String roleName;
}
