package com.im.service;

import com.im.common.Result;
import com.im.entity.ChatHistory;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 聊天记录表 服务类
 * </p>
 *
 * @author eleven
 * @since 2021-02-22
 */
public interface ChatHistoryService extends IService<ChatHistory> {

    /**
     * 查询私聊聊天记录
     * @param chatHistory 聊天记录实体
     * @return
     */
    Result queryPrivateChatHistory(ChatHistory chatHistory);

    /**
     * 发送聊天记录
     * @param chatHistory
     * @return
     */
    Result sendChat(ChatHistory chatHistory);
}
