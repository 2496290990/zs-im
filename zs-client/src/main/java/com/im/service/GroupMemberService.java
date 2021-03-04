package com.im.service;

import com.im.common.Result;
import com.im.entity.GroupMember;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 群组成员表 服务类
 * </p>
 *
 * @author eleven
 * @since 2021-02-22
 */
public interface GroupMemberService extends IService<GroupMember> {

    /**
     * 根据群组id查询群成员
     * @param id 要查询的群组id
     * @return
     */
    Result queryGroupMember(String id);

    /**
     * 删除群成员
     * @param groupMember 要删除的群成员详细信息
     * @return
     */
    Result delMember(GroupMember groupMember);


}
