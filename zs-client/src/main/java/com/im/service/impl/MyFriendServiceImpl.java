package com.im.service.impl;

import com.im.entity.MyFriend;
import com.im.mapper.MyFriendMapper;
import com.im.service.MyFriendService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
