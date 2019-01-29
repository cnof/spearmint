package com.spearmint.admin.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author 33992
 * @date 2019/1/22 11:26
 */
@Data
public class RoleMenuVO implements Serializable {

    private String roleId;

    private List<String> menuIds;
}
