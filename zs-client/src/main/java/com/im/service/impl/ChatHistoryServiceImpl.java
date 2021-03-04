package com.im.service.impl;

import com.im.common.Result;
import com.im.common.ResultFactory;
import com.im.entity.ChatHistory;
import com.im.mapper.ChatHistoryMapper;
import com.im.service.ChatHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 聊天记录表 服务实现类
 * </p>
 *
 * @author eleven
 * @since 2021-02-22
 */
@Service
public class ChatHistoryServiceImpl extends ServiceImpl<ChatHistoryMapper, ChatHistory> implements ChatHistoryService {

    @Autowired
    private ChatHistoryMapper chatHistoryMapper;

    @Override
    public Result queryPrivateChatHistory(ChatHistory chatHistory) {
        List<ChatHistory> chatHistoryList = chatHistoryMapper.selectChatHistory(chatHistory);
        return ResultFactory.success(chatHistoryList);
    }

    @Override
    public Result sendChat(ChatHistory chatHistory) {
        chatHistoryMapper.insert(chatHistory);
        // TODO: 2021/2/23 给好友发送消息
        return ResultFactory.success(null);
    }
}
