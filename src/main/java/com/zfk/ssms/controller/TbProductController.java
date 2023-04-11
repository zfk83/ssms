package com.zfk.ssms.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zfk.ssms.common.Result;
import com.zfk.ssms.domain.TbProduct;
import com.zfk.ssms.dto.ProductDTO;
import com.zfk.ssms.service.TbProductService;
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
@RequestMapping("/product")
public class TbProductController {
    @Autowired
    private TbProductService tbProductService;

    @PostMapping ("/add")
    public Result addProduct(@RequestBody ProductDTO productDTO) {
        boolean success = tbProductService.saveProduct(productDTO);
        return success ? Result.success(null, "添加成功") : Result.fail(null, "添加失败");
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
    public Result getProduct(Long productId) {
        if (productId == null) {
            return Result.success(tbProductService.getProductList(), "查询成功");
        } else {
            List<TbProduct> list = tbProductService.list(new LambdaQueryWrapper<TbProduct>().eq(TbProduct::getProductId, productId));
            return Result.success(list, "查询成功");
        }
    }

    @GetMapping("/list")
    public Result listProduct() {
        return Result.success(tbProductService.getProductList(), null);
    }


}
