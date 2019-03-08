package com.spearmint.admin.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 33992
 * @date 2018/12/1 18:36
 */
@Data
public class Role implements Serializable {

    private String roleId;

    private String roleCode;

    private String roleName;
}
