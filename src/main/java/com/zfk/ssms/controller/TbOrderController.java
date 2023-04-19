package com.zfk.ssms.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zfk.ssms.common.Result;
import com.zfk.ssms.domain.TbOrder;
import com.zfk.ssms.service.TbOrderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
        if (tbOrderService.updateById(tbOrder)) {
            return Result.success(null, "更新成功");
        } else {
            return Result.fail(null, "更新失败");
        }
    }

    @GetMapping("/shipped")
    public Result shippedOrder(Long id) {
        TbOrder tbOrder = tbOrderService.getById(id);
        tbOrder.setOrderStatus("已发货");
        if (tbOrderService.updateById(tbOrder)) {
            return Result.success(null, "发货成功");
        } else {
            return Result.fail(null, "发货失败");
        }
    }
    @GetMapping("/shipped/list")
    public Result shippedOrderList() {
        LambdaQueryWrapper<TbOrder> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(TbOrder::getOrderStatus, "未发货");
        return Result.success(tbOrderService.list(queryWrapper), null);
    }

    @GetMapping("/returnGoods")
    public Result returnOrder(Long id) {
        TbOrder tbOrder = tbOrderService.getById(id);
        tbOrder.setOrderStatus("已退货");
        if (tbOrderService.updateById(tbOrder)) {
            return Result.success(null, "退货成功");
        } else {
            return Result.fail(null, "退货失败");
        }
    }

    @GetMapping("/returnGoods/list")
    public Result returnOrderList() {
        LambdaQueryWrapper<TbOrder> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(TbOrder::getOrderStatus, "已发货");
        return Result.success(tbOrderService.list(queryWrapper), "查询成功");
    }

    @PostMapping("/get")
    public Result getOrder(@RequestBody Map<String, Object> map) {
        Long orderId = StringUtils.isEmpty(map.get("orderId")) ? null : Long.valueOf((String) map.get("orderId"));
        Long userId = StringUtils.isEmpty(map.get("userId")) ? null : Long.valueOf((String) map.get("userId"));
        String orderStatus = (String) map.get("orderStatus");
        List<Date> orderTime = (List<Date>) map.get("orderTime");
        if ((orderId == null) && (userId == null) && (StringUtils.isEmpty(orderStatus))&& (orderTime == null)) {
            return Result.success(tbOrderService.list(), "查询成功");
        }
        if (orderId != null) {
            LambdaQueryWrapper<TbOrder> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(TbOrder::getOrderId, orderId);
            return Result.success(tbOrderService.list(queryWrapper), "查询成功");
        }
        if (userId != null) {
            LambdaQueryWrapper<TbOrder> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(TbOrder::getUserId, userId);
            return Result.success(tbOrderService.list(queryWrapper), "查询成功");
        }
        if (!StringUtils.isEmpty(orderStatus)) {
            LambdaQueryWrapper<TbOrder> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(TbOrder::getOrderStatus, orderStatus);
            return Result.success(tbOrderService.list(queryWrapper), "查询成功");
        }
        if (orderTime != null) {
            LambdaQueryWrapper<TbOrder> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.between(TbOrder::getOrderTime, orderTime.get(0), orderTime.get(1));
            return Result.success(tbOrderService.list(queryWrapper), "查询成功");
        }
        return Result.fail(null, "查询失败");
    }

    @GetMapping("/getById")
    public Result getOrderById(Long id) {
        return Result.success(tbOrderService.getById(id), null);
    }

    @GetMapping("/list")
    public Result ListOrder() {
        return Result.success(tbOrderService.list(), null);
    }
}
