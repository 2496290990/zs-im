package com.im.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author eleven
 * @since 2021-02-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("im_user")
@ApiModel(value="User对象", description="用户信息表")
public class User implements Serializable {

private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "生成的雪花id")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "账号")
    private String account;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "随机盐")
    private String salt;

    @ApiModelProperty(value = "0女1男2保密")
    private Integer sex;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "0删除1正常2封禁")
    @TableLogic
    private String delFlag;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "头像地址")
    private String accountUrl;

    @ApiModelProperty(value = "昵称")
    private String username;

    @ApiModelProperty(value = "简介")
    private String intro;

    @ApiModelProperty(value = "生日")
    private LocalDateTime birth;

    @ApiModelProperty(value = "备用1")
    private String by1;

    @ApiModelProperty(value = "备用2")
    private String by2;

    @ApiModelProperty(value = "备用3")
    private String by3;

    @ApiModelProperty(value = "备用4")
    private String by4;

    @ApiModelProperty(value = "备用5")
    private String by5;

    @ApiModelProperty(value = "备用6")
    private String by6;


}
