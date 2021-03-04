package com.im.controller;


import com.im.common.Result;
import com.im.service.CircleOfFriendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 动态记录表 前端控制器
 * </p>
 *
 * @author eleven
 * @since 2021-02-22
 */
@RestController
@RequestMapping("/circleOfFriend")
@Api(tags = "朋友圈/动态")
public class CircleOfFriendController {

    @Autowired
    private CircleOfFriendService friendService;

    @GetMapping("/query")
    @ApiOperation(value = "查询最新的20条朋友圈")
    public Result queryLast20Circles(){
        return friendService.queryLast20Circles();
    }

}

