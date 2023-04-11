package com.zfk.ssms.controller;

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
        tbOrderService.save(tbOrder);
        return Result.success(null, "添加成功");
    }

    @DeleteMapping("/delete")
    public Result deleteOrder(@RequestBody TbOrder tbOrder) {
        tbOrderService.removeById(tbOrder.getOrderId());
        return Result.success(null, "删除成功");
    }

    @PutMapping("/update")
    public Result updateOrder(@RequestBody TbOrder tbOrder) {
        tbOrderService.updateById(tbOrder);
        return Result.success(null, "更新成功");
    }

    @GetMapping("/get")
    public Result getOrder(@RequestBody Long orderId) {
        tbOrderService.getById(orderId);
        return Result.success(tbOrderService.getById(orderId), "查询成功");
    }
}
