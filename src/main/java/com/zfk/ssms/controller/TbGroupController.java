package com.zfk.ssms.controller;

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
        tbGroupService.updateById(tbGroup);
        return Result.success(null, "更新成功");
    }

    @GetMapping("/get")
    public Result getGroup(@RequestBody Long groupId) {
        tbGroupService.getById(groupId);
        return Result.success(tbGroupService.getById(groupId), "查询成功");
    }

    @GetMapping("/list")
    public Result listGroup() {
        return Result.success(tbGroupService.list(), null);
    }

}
