package com.zfk.ssms.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zfk.ssms.common.Result;
import com.zfk.ssms.domain.TbGroup;
import com.zfk.ssms.service.TbGroupService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author ZFK
 */

@Api
@RestController
@RequestMapping("/group")
public class TbGroupController {
    @Autowired
    private TbGroupService tbGroupService;

    @PostMapping("/add")
    public Result addGroup(@RequestBody TbGroup tbGroup) {
        boolean success = tbGroupService.save(tbGroup);
        return success ? Result.success(null, "添加成功") : Result.fail(null, "添加失败");
    }

    @DeleteMapping("/delete")
    public Result deleteGroup(Long id) {
        tbGroupService.removeById(id);
        return Result.success(null, "删除成功");
    }

    @PutMapping("/update")
    public Result updateGroup(@RequestBody TbGroup tbGroup) {
        if (tbGroupService.updateById(tbGroup)) {
            return Result.success(null, "更新成功");
        } else {
            return Result.fail(null, "更新失败");
        }
    }

    @GetMapping("/get")
    public Result getGroup(Long groupId) {
        if (groupId == null) {
            return Result.success(tbGroupService.list(), "查询成功");
        }
        if (groupId != null) {
            LambdaQueryWrapper<TbGroup> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(TbGroup::getGroupId, groupId);
            return Result.success(tbGroupService.list(queryWrapper), "查询成功");
        }
        return Result.fail(null, "查询失败");
    }

    @GetMapping("/getById")
    public Result getGroupById(Long id) {
        return Result.success(tbGroupService.getById(id), null);
    }

    @GetMapping("/list")
    public Result listGroup() {
        return Result.success(tbGroupService.list(), null);
    }

}
