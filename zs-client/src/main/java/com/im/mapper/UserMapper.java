package com.im.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.im.entity.ImUser;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author eleven
 * @since 2021-02-22
 */
public interface UserMapper extends BaseMapper<ImUser> {


    IPage<ImUser> selectUserPageByLike(Page page, ImUser imUser);

    /**
     * 根据注册账号查询是否被注册过
     * @param subject
     * @return
     */
    ImUser verifySameByRegisterSubject(String subject);
}
