package com.spearmint.framework.mybatis.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 33992
 * @date 2019/1/29 11:38
 */
@Data
public class CommonEntity implements Serializable {

    @ApiModelProperty(hidden = true)
    private Date createDate;

    @ApiModelProperty(hidden = true)
    private String createUserId;

    @ApiModelProperty(hidden = true)
    private String createUserName;

    @ApiModelProperty(hidden = true)
    private Date modifyDate;

    @ApiModelProperty(hidden = true)
    private String modifyUserId;

    @ApiModelProperty(hidden = true)
    private String modifyUserName;
}
