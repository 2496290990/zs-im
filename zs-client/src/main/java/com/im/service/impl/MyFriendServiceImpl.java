package com.im.service.impl;

import com.im.common.Result;
import com.im.common.ResultFactory;
import com.im.entity.MyFriend;
import com.im.entity.SysUser;
import com.im.mapper.MyFriendMapper;
import com.im.service.MyFriendService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.im.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 好友关系表 服务实现类
 * </p>
 *
 * @author eleven
 * @since 2021-02-22
 */
@Service
public class MyFriendServiceImpl extends ServiceImpl<MyFriendMapper, MyFriend> implements MyFriendService {

    @Autowired
    private MyFriendMapper myFriendMapper;

    @Override
    public Result queryMyFriend() {
        SysUser userInfo = SecurityUtils.getUserInfo();
        List<MyFriend> myFriendList =  myFriendMapper.queryMyFriendByUserId(userInfo.getId());
        return ResultFactory.success(myFriendList);
    }
}
