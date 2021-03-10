package com.im.service;

import com.im.common.Result;
import com.im.entity.CircleOfFriend;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 动态记录表 服务类
 * </p>
 *
 * @author eleven
 * @since 2021-02-22
 */
public interface CircleOfFriendService extends IService<CircleOfFriend> {

    /**
     * 查询最新的20条动态信息
     * @return
     */
    Result queryLast20Circles();

    /**
     *
     * @param circleOfFriend
     * @param files
     * @exception IOException 返回文件读取异常
     * @return
     */
    Result insertNew(CircleOfFriend circleOfFriend, List<MultipartFile> files) throws IOException;

    /**
     * 查询自己的朋友圈内容
     * @param friend
     * @return
     */
    Result queryOwnCircle(CircleOfFriend friend);
}
