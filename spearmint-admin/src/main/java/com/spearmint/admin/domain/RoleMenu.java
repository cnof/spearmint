package com.spearmint.admin.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 33992
 * @date 2018/12/1 19:48
 */
@Data
public class RoleMenu implements Serializable {

    private String roleMenuId;

    private String roleId;

    private String menuId;
}
