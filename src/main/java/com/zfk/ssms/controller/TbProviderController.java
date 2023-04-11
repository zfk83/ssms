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
        tbProviderService.updateById(tbProvider);
        return Result.success(null, "更新成功");
    }

    @GetMapping("/get")
    public Result getProvider(String contactPhone) {
        if (StringUtils.isEmpty(contactPhone)) {
            return Result.success(tbProviderService.list(), "查询成功");
        } else {
            List<TbProvider> list = tbProviderService.list(new LambdaQueryWrapper<TbProvider>().eq(TbProvider::getContactPhone, contactPhone));
            return Result.success(list, "查询成功");
        }
    }

    @GetMapping("/list")
    public Result listProvider() {
        return Result.success(tbProviderService.list(), null);
    }
}
