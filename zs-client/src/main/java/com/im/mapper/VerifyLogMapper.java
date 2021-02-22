package com.im.mapper;

import com.im.entity.VerifyLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 验证码记录表 Mapper 接口
 * </p>
 *
 * @author eleven
 * @since 2021-02-22
 */
public interface VerifyLogMapper extends BaseMapper<VerifyLog> {

    /**
     * 获取最后一个验证码
     * @param verifyLog
     * @return
     */
    VerifyLog getLastCode(VerifyLog verifyLog);
}
