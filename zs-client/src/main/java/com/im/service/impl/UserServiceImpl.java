package com.im.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.im.common.Result;
import com.im.common.ResultFactory;
import com.im.entity.User;
import com.im.mapper.UserMapper;
import com.im.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author eleven
 * @since 2021-02-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public IPage<User> selectUserPageByLike(Page page, User user) {
        return userMapper.selectUserPageByLike(page,user);
    }

    @Override
    public Result verifySameByRegisterSubject(String subject) {
        User user = userMapper.verifySameByRegisterSubject(subject);
        return user != null ?
                ResultFactory.fail("账号已经被注册啦！") :
                ResultFactory.success(null);
    }
}
