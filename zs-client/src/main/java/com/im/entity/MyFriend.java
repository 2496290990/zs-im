package com.im.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 好友关系表
 * </p>
 *
 * @author eleven
 * @since 2021-02-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("im_my_friend")
@ApiModel(value="MyFriend对象", description="好友关系表")
public class MyFriend implements Serializable {

private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "我的id")
    private String myId;

    @ApiModelProperty(value = "好友id")
    private String friendId;

    @ApiModelProperty(value = "0 正常好友 1特别关系")
    private String particular;

    @ApiModelProperty(value = "0正常 1 黑名单 2被拉黑")
    private String blocked;

    @ApiModelProperty(value = "0删除 1正常")
    @TableLogic
    private String delFlag;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "备注")
    private String nickname;

    @ApiModelProperty(value = "标签")
    private String tag;

    @ApiModelProperty(value = "简介")
    private String intro;

    @ApiModelProperty(value = "好友分组")
    private String friendGroup;

    @ApiModelProperty(value = "不要")
    private String by1;

    private String by2;

    private String by3;


}
