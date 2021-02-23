package com.im.controller;


import com.im.common.Result;
import com.im.entity.ChatGroup;
import com.im.service.ChatGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 聊天群组表 前端控制器
 * </p>
 *
 * @author eleven
 * @since 2021-02-22
 */
@RestController
@RequestMapping("/chatGroup")
@Api("群聊控制器")
public class ChatGroupController {

    @Autowired
    private ChatGroupService chatGroupService;

    @PostMapping("/create")
    @ApiOperation(value = "创建群组")
    public Result createNewGroup(@RequestBody ChatGroup chatGroup){
        return chatGroupService.createNewGroup(chatGroup);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id查询群组信息")
    public Result queryGroupById(@PathVariable("id") String id){
        return chatGroupService.queryGroupById(id);
    }

    @PutMapping("/edit")
    @ApiOperation(value = "修改群组信息")
    public Result editGroupById(@RequestBody ChatGroup chatGroup){
        return chatGroupService.editGroupById(chatGroup);
    }

    @PutMapping("/del")
    @ApiOperation(value = "解散群组")
    public Result delGroup(@RequestBody ChatGroup chatGroup){
        return chatGroupService.delGroup(chatGroup);
    }
}

