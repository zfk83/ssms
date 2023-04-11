package com.zfk.ssms.controller;

import com.zfk.ssms.common.Result;
import com.zfk.ssms.domain.TbOrderDetail;
import com.zfk.ssms.service.TbOrderDetailService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping("/orderDetail")
public class TbOrderDetailController {
    @Autowired
    private TbOrderDetailService tbOrderDetailService;

    @PostMapping("/add")
    public Result addOrderDetail(@RequestBody TbOrderDetail tbOrderDetail) {
        tbOrderDetailService.save(tbOrderDetail);
        return Result.success(null, "添加成功");
    }

    @DeleteMapping("/delete")
    public Result deleteOrderDetail(@RequestBody TbOrderDetail tbOrderDetail) {
        tbOrderDetailService.removeById(tbOrderDetail.getDetailId());
        return Result.success(null, "删除成功");
    }

    @PutMapping("/update")
    public Result updateOrderDetail(@RequestBody TbOrderDetail tbOrderDetail) {
        tbOrderDetailService.updateById(tbOrderDetail);
        return Result.success(null, "更新成功");
    }

    @GetMapping("/get")
    public Result getOrderDetail(@RequestBody Long detailId) {
        tbOrderDetailService.getById(detailId);
        return Result.success(tbOrderDetailService.getById(detailId), "查询成功");
    }

}
