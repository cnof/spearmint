package com.spearmint.admin.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.spearmint.framework.excel.annotation.ExcelField;
import com.spearmint.framework.mybatis.pojo.CommonEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

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

    @ExcelField(columnOrder = 0, columnName = "公司")
    private String companyId;

    @ExcelField(columnOrder = 1, columnName = "部门")
    private String departmentId;

    private Integer innerUser;

    private String code;

    @ExcelField(columnOrder = 2, columnName = "用户名")
    @ApiModelProperty(name = "username", value = "登录账户", required = true)
    private String username;

    private String password;

    private Date lastPasswordResetDate;

    private String secretKey;

    @ExcelField(columnOrder = 3, columnName = "姓名")
    private String realName;

    @ExcelField(columnOrder = 4, columnName = "性别")
    private String gender;

    private Integer deleteMark;

    private Integer enabled;

    @ExcelField(columnOrder = 5, columnName = "备注")
    private String remark;
}
