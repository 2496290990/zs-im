package com.im.entity;

import lombok.Data;

/**
 * @author zhaojinhui
 * @date 2021/2/22 18:32
 * @apiNote
 */
@Data
public class SysUser {

    /** 用户id */
    private String id;

    /** 用户账号 */
    private String account;

    /** 头像地址 */
    private String url;

    /** 用户名称  */
    private String username;

    /** 用户简介 */
    private String intro;
}
