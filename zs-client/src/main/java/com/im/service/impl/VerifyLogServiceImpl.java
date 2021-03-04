package com.im.service.impl;

import cn.hutool.core.util.StrUtil;
import com.im.common.Result;
import com.im.common.ResultFactory;
import com.im.entity.VerifyLog;
import com.im.mapper.VerifyLogMapper;
import com.im.service.VerifyLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.im.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 验证码记录表 服务实现类
 * </p>
 *
 * @author eleven
 * @since 2021-02-22
 */
@Service
public class VerifyLogServiceImpl extends ServiceImpl<VerifyLogMapper, VerifyLog> implements VerifyLogService {

    @Autowired
    private VerifyLogMapper verifyLogMapper;

    private SnowFlake snowFlake = SnowFlake.getSnowFlake();

    @Override
    public void saveEmailCode(VerifyLog verifyLog) {
        verifyLog.setId(snowFlake.nextId());
        verifyLog.setExpireTime(LocalDateTime.now().plusMinutes(3));
        verifyLog.setType(0);
        verifyLogMapper.insert(verifyLog);
    }

    @Override
    public Result verifyLastCode(VerifyLog verifyLog) {
        VerifyLog queryLog = verifyLogMapper.getLastCode(verifyLog);
        if(LocalDateTime.now().isBefore(queryLog.getExpireTime())){
            if(StrUtil.equals(queryLog.getVerifyCode(), verifyLog.getVerifyCode())){
                return ResultFactory.success(true);
            }
            return ResultFactory.fail("验证码错误");
        }
        return ResultFactory.fail("验证码失效");

    }
}
