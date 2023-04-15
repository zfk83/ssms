package com.zfk.ssms.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zfk.ssms.common.Result;
import com.zfk.ssms.domain.TbProvider;
import com.zfk.ssms.service.TbProviderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ZFK
 */
@Api
@RestController
@RequestMapping("/provider")
public class  TbProviderController {
    @Autowired
    private TbProviderService tbProviderService;

    @PostMapping("/add")
    public Result addProvider(@RequestBody TbProvider tbProvider) {
        boolean success = tbProviderService.save(tbProvider);
        return success ? Result.success(null, "添加成功") : Result.fail(null, "添加失败");
    }

    @DeleteMapping("/delete")
    public Result deleteProvider(Long id) {
        tbProviderService.removeById(id);
        return Result.success(null, "删除成功");
    }

    @PutMapping("/update")
    public Result updateProvider(@RequestBody TbProvider tbProvider) {
        if (tbProviderService.updateById(tbProvider)) {
            return Result.success(null, "更新成功");
        } else {
            return Result.fail(null, "更新失败");
        }
    }

    @GetMapping("/get")
    public Result getProvider(String contactPhone) {
        if (StringUtils.isEmpty(contactPhone)) {
            return Result.success(tbProviderService.list(), "查询成功");
        }
        if (!StringUtils.isEmpty(contactPhone)) {
            LambdaQueryWrapper<TbProvider> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(TbProvider::getContactPhone, contactPhone);
            return Result.success(tbProviderService.list(queryWrapper), "查询成功");
        }
        return Result.fail(null, "查询失败");
    }

    @GetMapping("/getById")
    public Result getProviderById(Long id) {
        return Result.success(tbProviderService.getById(id), null);
    }

    @GetMapping("/list")
    public Result listProvider() {
        return Result.success(tbProviderService.list(), null);
    }
}
