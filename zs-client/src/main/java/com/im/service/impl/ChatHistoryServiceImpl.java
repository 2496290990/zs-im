package com.im.service.impl;

import com.im.entity.ChatHistory;
import com.im.mapper.ChatHistoryMapper;
import com.im.service.ChatHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
