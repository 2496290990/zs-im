package com.im.service;

import com.im.common.Result;
import com.im.entity.FriendApply;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 好友申请记录表 服务类
 * </p>
 *
 * @author eleven
 * @since 2021-02-22
 */
public interface FriendApplyService extends IService<FriendApply> {

    /**
     * 发起加好友申请
     * @param friendApply
     * @return
     */
    Result applyToAdd(FriendApply friendApply);

    /**
     * 0拒绝添加 1同意申请
     * @param friendApply 要处理的好友申请请求
     * @return
     */
    Result operationApply(FriendApply friendApply);
}
