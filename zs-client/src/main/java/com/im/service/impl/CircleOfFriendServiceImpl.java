package com.im.service.impl;

import com.im.common.Result;
import com.im.entity.CircleOfFriend;
import com.im.entity.SysUser;
import com.im.mapper.CircleOfFriendMapper;
import com.im.service.CircleOfFriendService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.im.utils.SecurityUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 动态记录表 服务实现类
 * </p>
 *
 * @author eleven
 * @since 2021-02-22
 */
@Service
public class CircleOfFriendServiceImpl extends ServiceImpl<CircleOfFriendMapper, CircleOfFriend> implements CircleOfFriendService {

    @Override
    public Result queryLast20Circles() {
        SysUser userInfo = SecurityUtils.getUserInfo();
        return null;
    }
}
