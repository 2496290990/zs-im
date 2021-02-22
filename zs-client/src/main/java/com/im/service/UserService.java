package com.im.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.im.common.Result;
import com.im.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author eleven
 * @since 2021-02-22
 */
public interface UserService extends IService<User> {

    /**
     * 分页模糊查询
     * @param page
     * @param user
     * @return
     */
    IPage<User> selectUserPageByLike(Page page, User user);

    /**
     * 验证账号是否注册过
     * @param subject 要注册的账号主体
     * @return
     */
    Result verifySameByRegisterSubject(String subject);
}
