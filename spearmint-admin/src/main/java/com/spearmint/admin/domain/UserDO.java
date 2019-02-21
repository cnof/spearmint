package com.spearmint.admin.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.spearmint.framework.mybatis.pojo.CommonEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author 33992
 * @date 2018/12/2 20:33
 */
@Data
@TableName("admin_user")
@EqualsAndHashCode(callSuper = true)
public class UserDO extends CommonEntity implements Serializable {

    @TableId(value = "user_id", type = IdType.UUID)
    private String userId;

    private String companyId;

    private String departmentId;

    private Integer innerUser;

    private String code;

    @ApiModelProperty(name = "username", value = "登录账户", required = true)
    private String username;

    private String password;

    private Date lastPasswordResetDate;

    private String secretKey;

    private String realName;

    private String gender;

    private Integer deleteMark;

    private Integer enabled;

    private String remark;

    @TableField(exist = false)
    private List<RoleDO> roles;
}
