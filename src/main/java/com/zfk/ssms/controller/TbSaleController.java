package com.zfk.ssms.controller;

import com.zfk.ssms.common.Result;
import com.zfk.ssms.domain.TbSale;
import com.zfk.ssms.service.TbSaleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping("/sale")
public class TbSaleController {
    @Autowired
    private TbSaleService tbSaleService;

    @PostMapping("/add")
    public Result addSale(@RequestBody TbSale tbSale) {
        tbSaleService.save(tbSale);
        return Result.success(null, "添加成功");
    }

    @DeleteMapping("/delete")
    public Result deleteSale(@RequestBody TbSale tbSale) {
        tbSaleService.removeById(tbSale.getSaleId());
        return Result.success(null, "删除成功");
    }

    @PutMapping("/update")
    public Result updateSale(@RequestBody TbSale tbSale) {
        tbSaleService.updateById(tbSale);
        return Result.success(null, "更新成功");
    }

    @GetMapping("/get")
    public Result getSale(@RequestBody Long saleId) {
        tbSaleService.getById(saleId);
        return Result.success(tbSaleService.getById(saleId), "查询成功");
    }


}
