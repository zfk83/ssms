package com.zfk.ssms.controller;

import com.zfk.ssms.common.Result;
import com.zfk.ssms.domain.TbProvider;
import com.zfk.ssms.service.TbProviderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author ZFK
 */
@Api
@RestController
@RequestMapping("/provider")
@CrossOrigin
public class TbProviderController {
    @Autowired
    private TbProviderService tbProviderService;

    @PostMapping("/add")
    public Result addProvider(@RequestBody TbProvider tbProvider) {
        tbProviderService.save(tbProvider);
        return Result.success(null, "添加成功");
    }

    @DeleteMapping("/delete")
    public Result deleteProvider(@RequestBody TbProvider tbProvider) {
        tbProviderService.removeById(tbProvider.getProviderId());
        return Result.success(null, "删除成功");
    }

    @PutMapping("/update")
    public Result updateProvider(@RequestBody TbProvider tbProvider) {
        tbProviderService.updateById(tbProvider);
        return Result.success(null, "更新成功");
    }

    @GetMapping("/get")
    public Result getGroup(@RequestBody Long groupId) {
        tbProviderService.getById(groupId);
        return Result.success(tbProviderService.getById(groupId), "查询成功");
    }
}
