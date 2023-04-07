package com.zfk.ssms.controller;

import com.zfk.ssms.common.Result;
import com.zfk.ssms.domain.TbProduct;
import com.zfk.ssms.service.TbProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author ZFK
 */
@Api
@RestController
@RequestMapping("/product")
@CrossOrigin
public class TbProductController {
    @Autowired
    private TbProductService tbProductService;

    @PostMapping ("/add")
    public Result addProduct(@RequestBody TbProduct tbProduct) {
        tbProductService.save(tbProduct);
        return Result.success(null, "添加成功");
    }

    @DeleteMapping ("/delete")
    public Result deleteProduct(Long id) {
        tbProductService.removeById(id);
        return Result.success(null, "删除成功");
    }

    @PutMapping ("/update")
    public Result updateProduct(@RequestBody TbProduct tbProduct) {
        tbProductService.updateById(tbProduct);
        return Result.success(null, "更新成功");
    }

    @GetMapping("/get")
    public Result getGroup(@RequestBody Long groupId) {
        tbProductService.getById(groupId);
        return Result.success(tbProductService.getById(groupId), "查询成功");
    }

    @GetMapping("/list")
    public Result listProduct() {
        return Result.success(tbProductService.getProductList(), null);
    }


}
