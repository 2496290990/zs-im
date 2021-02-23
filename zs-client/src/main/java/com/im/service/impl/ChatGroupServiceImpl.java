package com.im.service.impl;

import com.im.common.Result;
import com.im.common.ResultFactory;
import com.im.entity.ChatGroup;
import com.im.entity.SysUser;
import com.im.mapper.ChatGroupMapper;
import com.im.service.ChatGroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.im.util.SecurityUtils;
import com.im.util.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 聊天群组表 服务实现类
 * </p>
 *
 * @author eleven
 * @since 2021-02-22
 */
@Service
public class ChatGroupServiceImpl extends ServiceImpl<ChatGroupMapper, ChatGroup> implements ChatGroupService {

    @Autowired
    private ChatGroupMapper chatGroupMapper;

    private SnowFlake snowFlake = SnowFlake.getSnowFlake();

    @Override
    public Result createNewGroup(ChatGroup chatGroup) {
        SysUser userInfo = SecurityUtils.getUserInfo();
        chatGroup.setId(snowFlake.nextId());
        chatGroup.setCreateId(userInfo.getId());
        int insert = chatGroupMapper.insert(chatGroup);
        if(insert > 0){
            return ResultFactory.success(chatGroup.getId());
        }
        return ResultFactory.fail("创建群组失败");
    }

    @Override
    public Result queryGroupById(String id) {
        ChatGroup chatGroup = chatGroupMapper.selectById(id);
        return ResultFactory.success(chatGroup);
    }

    @Override
    public Result editGroupById(ChatGroup chatGroup) {
        return ResultFactory.success(chatGroupMapper.updateById(chatGroup));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Result delGroup(ChatGroup chatGroup) {

        return null;
    }
}
