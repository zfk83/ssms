package com.zfk.ssms.controller;

import com.zfk.ssms.common.Result;
import com.zfk.ssms.domain.TbPurchase;
import com.zfk.ssms.service.TbPurchaseService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author ZFK
 */
@Api
@RestController
@RequestMapping("/purchase")
@CrossOrigin
public class TbPurchaseController {
    @Autowired
    private TbPurchaseService tbPurchaseService;

    @PostMapping("/add")
    public Result addPurchase(@RequestBody TbPurchase tbPurchase) {
        tbPurchaseService.save(tbPurchase);
        return Result.success(null, "添加成功");
    }

    @DeleteMapping("/delete")
    public Result deletePurchase(Long id) {
        tbPurchaseService.removeById(id);
        return Result.success(null, "删除成功");
    }

    @PutMapping("/update")
    public Result updatePurchase(@RequestBody TbPurchase tbPurchase) {
        tbPurchaseService.updateById(tbPurchase);
        return Result.success(null, "更新成功");
    }

    @GetMapping("/get")
    public Result getGroup(@RequestBody Long groupId) {
        tbPurchaseService.getById(groupId);
        return Result.success(tbPurchaseService.getById(groupId), "查询成功");
    }

    @GetMapping("/list")
    public Result listPurchase() {
        return Result.success(tbPurchaseService.list(), null);
    }
}
