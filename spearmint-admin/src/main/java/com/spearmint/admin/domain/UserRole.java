package com.spearmint.admin.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 33992
 * @date 2018/12/1 18:40
 */
@Data
public class UserRole implements Serializable {

    private String userRoleId;

    private String roleId;

    private String userId;
}
