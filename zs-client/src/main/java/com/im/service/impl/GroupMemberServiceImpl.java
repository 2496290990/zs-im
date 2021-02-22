package com.im.service.impl;

import com.im.entity.GroupMember;
import com.im.mapper.GroupMemberMapper;
import com.im.service.GroupMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 群组成员表 服务实现类
 * </p>
 *
 * @author eleven
 * @since 2021-02-22
 */
@Service
public class GroupMemberServiceImpl extends ServiceImpl<GroupMemberMapper, GroupMember> implements GroupMemberService {

}
