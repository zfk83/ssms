package com.zfk.ssms.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zfk.ssms.common.Result;
import com.zfk.ssms.domain.TbPurchase;
import com.zfk.ssms.service.TbPurchaseService;
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
@RequestMapping("/purchase")
public class TbPurchaseController {
    @Autowired
    private TbPurchaseService tbPurchaseService;

    @PostMapping("/add")
    public Result addPurchase(@RequestBody TbPurchase tbPurchase) {
        boolean success = tbPurchaseService.save(tbPurchase);
        return success ? Result.success(null, "添加成功") : Result.fail(null, "添加失败");
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
    public Result getPurchase(Long purchaseId) {
        if (purchaseId == null) {
            return Result.success(tbPurchaseService.list(), "查询成功");
        } else {
            List<TbPurchase> list = tbPurchaseService.list(new LambdaQueryWrapper<TbPurchase>().eq(TbPurchase::getPurchaseId, purchaseId));
            return Result.success(list, "查询成功");
        }
    }

    @GetMapping("/list")
    public Result listPurchase() {
        return Result.success(tbPurchaseService.list(), null);
    }
}
