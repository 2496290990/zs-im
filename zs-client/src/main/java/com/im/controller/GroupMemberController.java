package com.im.controller;


import com.im.common.Result;
import com.im.entity.GroupMember;
import com.im.service.GroupMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 群组成员表 前端控制器
 * </p>
 *
 * @author eleven
 * @since 2021-02-22
 */
@RestController
@RequestMapping("/groupMember")
@Api(tags = "群成员")
public class GroupMemberController {

    @Autowired
    private GroupMemberService groupMemberService;

    @GetMapping("/query/{id}")
    @ApiOperation(value = "查询群组成员")
    public Result queryGroupMember(@PathVariable("id") String id){
        return groupMemberService.queryGroupMember(id);
    }


    @PutMapping("/delMember")
    @ApiOperation(value = "删除群成员")
    public Result delMember(@RequestBody GroupMember groupMember){
        return groupMemberService.delMember(groupMember);
    }

}

