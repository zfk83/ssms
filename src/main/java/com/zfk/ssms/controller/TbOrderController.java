package com.zfk.ssms.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zfk.ssms.common.Result;
import com.zfk.ssms.domain.TbOrder;
import com.zfk.ssms.service.TbOrderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author ZFK
 */
@Api
@RestController
@RequestMapping("/order")
public class TbOrderController {
    @Autowired
    private TbOrderService tbOrderService;

    @PostMapping("/add")
    public Result addOrder(@RequestBody TbOrder tbOrder) {
        boolean success = tbOrderService.save(tbOrder);
        return success ? Result.success(null, "添加成功") : Result.fail(null, "添加失败");
    }

    @DeleteMapping("/delete")
    public Result deleteOrder(Long id) {
        tbOrderService.removeById(id);
        return Result.success(null, "删除成功");
    }

    @PutMapping("/update")
    public Result updateOrder(@RequestBody TbOrder tbOrder) {
        tbOrderService.updateById(tbOrder);
        return Result.success(null, "更新成功");
    }

    @GetMapping("/get")
    public Result getOrder(Long orderId, Long userId) {
        if ((orderId == null)&&(userId == null)) {
            return Result.success(tbOrderService.list(), "查询成功");
        }
        if(orderId != null) {
            LambdaQueryWrapper<TbOrder> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(TbOrder::getOrderId, orderId);
            return Result.success(tbOrderService.list(queryWrapper), "查询成功");
        }
        if(userId != null) {
            LambdaQueryWrapper<TbOrder> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(TbOrder::getUserId, userId);
            return Result.success(tbOrderService.list(queryWrapper), "查询成功");
        }
        return Result.fail(null, "查询失败");
    }

    @GetMapping("/list")
    public Result ListOrder() {
        return Result.success(tbOrderService.list(), null);
    }
}
