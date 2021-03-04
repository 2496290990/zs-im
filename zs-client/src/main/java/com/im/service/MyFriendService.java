package com.im.service;

import com.im.common.Result;
import com.im.entity.MyFriend;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 好友关系表 服务类
 * </p>
 *
 * @author eleven
 * @since 2021-02-22
 */
public interface MyFriendService extends IService<MyFriend> {

    /**
     * 查询我的好友列表
     * @return
     */
    Result queryMyFriend();
}
