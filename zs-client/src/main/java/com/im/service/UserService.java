package com.im.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.im.common.Result;
import com.baomidou.mybatisplus.extension.service.IService;
import com.im.entity.ImUser;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author eleven
 * @since 2021-02-22
 */
public interface UserService extends IService<ImUser> {

    /**
     * 分页模糊查询
     * @param page
     * @param imUser
     * @return
     */
    IPage<ImUser> selectUserPageByLike(Page page, ImUser imUser);

    /**
     * 验证账号是否注册过
     * @param subject 要注册的账号主体
     * @return
     */
    Result verifySameByRegisterSubject(String subject);

    /**
     * 注册用户
     * @param imUser
     * @return
     */
    Result registerUser(ImUser imUser);
}
