package com.spearmint.admin.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 33992
 * @date 2018/12/2 20:33
 */
@Data
public class User implements Serializable {

    private String userId;

    @ApiModelProperty(name = "username", value = "登录账户", required = true)
    private String username;

    private String password;

    private Date lastPasswordResetDate;

    private String realName;

    private Integer enabled;

    private String remark;
}
