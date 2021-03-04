package com.im.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.im.common.Result;
import com.im.common.ResultFactory;
import com.im.entity.ImUser;
import com.im.mapper.UserMapper;
import com.im.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.im.utils.SnowFlake;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, ImUser> implements UserService {

    @Autowired
    private UserMapper userMapper;

    private SnowFlake snowFlake = SnowFlake.getSnowFlake();

    @Override
    public IPage<ImUser> selectUserPageByLike(Page page, ImUser imUser) {
        return userMapper.selectUserPageByLike(page, imUser);
    }

    @Override
    public Result verifySameByRegisterSubject(String subject) {
        ImUser imUser = userMapper.verifySameByRegisterSubject(subject);
        return imUser != null ?
                ResultFactory.fail("账号已经被注册啦！") :
                ResultFactory.success(null);
    }

    @Override
    public Result registerUser(ImUser imUser) {
        imUser.setId(snowFlake.nextId());
        imUser.setPassword(SecureUtil.md5(imUser.getPassword()));
        int insert = userMapper.insert(imUser);
        return ResultFactory.success(insert);
    }
}
