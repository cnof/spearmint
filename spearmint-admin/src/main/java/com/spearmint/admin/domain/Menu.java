package com.spearmint.admin.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 33992
 * @date 2018/12/1 19:37
 */
@Data
public class Menu implements Serializable {

    private String menuId;

    @ApiModelProperty(name = "parentId", value = "父菜单ID,如果菜单为顶级菜单值为0", required = true)
    private String parentId;

    @ApiModelProperty(name = "menuName", value = "菜单名称", required = true)
    private String menuName;

    @ApiModelProperty(name = "menuCode", value = "菜单编码，可以用来排序同一父菜单下的菜单", required = true)
    private String menuCode;

    @ApiModelProperty(name = "menuLocation", value = "菜单的英文名称", required = true)
    private String menuLocation;

    private String url;

    @ApiModelProperty(name = "perms", value = "菜单权限")
    private String perms;

    @ApiModelProperty(name = "icon", value = "菜单图标")
    private String icon;

    @ApiModelProperty(name = "level", value = "菜单层次，顶级为0层", required = true)
    private Integer level;

    @ApiModelProperty(name = "type", value = "菜单类型，1目录-2页面-3按钮", required = true)
    private Integer type;
}
