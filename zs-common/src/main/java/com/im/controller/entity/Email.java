package com.im.controller.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zhaojinhui
 * @date 2021/2/20 10:37
 * @apiNote
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email {

    /** 发件人地址 */
    private String from;

    /** 收件人地址 */
    private String sendTo;

    /** 主题 */
    private String subject;

    /** 邮件内容*/
    private String text;
}
