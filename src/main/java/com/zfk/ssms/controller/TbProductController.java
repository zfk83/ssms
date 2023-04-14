package com.zfk.ssms.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zfk.ssms.common.Result;
import com.zfk.ssms.domain.TbProduct;
import com.zfk.ssms.dto.ProductDTO;
import com.zfk.ssms.service.TbProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
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
    public Result updateProduct(@RequestBody ProductDTO productDTO) {
        if(tbProductService.updateProduct(productDTO)) {
            return Result.success(null, "更新成功");
        }else {
            return Result.fail(null, "更新失败");
        }
    }

    @GetMapping("/get")
    public Result getProduct(Long productId, String productName, Long groupId) {
        if ((productId == null)&&(StringUtils.isEmpty(productName))&&(groupId == null)) {
            return Result.success(tbProductService.getProductList(), "查询成功");
        }
        if(productId != null) {
            LambdaQueryWrapper<TbProduct> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(TbProduct::getProductId, productId);
            return Result.success(tbProductService.list(queryWrapper), "查询成功");
        }
        if(!StringUtils.isEmpty(productName)) {
            LambdaQueryWrapper<TbProduct> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(TbProduct::getProductName, productName);
            return Result.success(tbProductService.list(queryWrapper), "查询成功");
        }
        if(groupId != null) {
            LambdaQueryWrapper<TbProduct> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(TbProduct::getGroupId, groupId);
            return Result.success(tbProductService.list(queryWrapper), "查询成功");
        }
        return Result.fail(null, "查询失败");
    }
    @GetMapping("/getById")
    public Result getProductById(Long id) {
        return Result.success(tbProductService.getProductById(id), null);
    }

    @GetMapping("/list")
    public Result listProduct() {
        return Result.success(tbProductService.getProductList(), null);
    }


}
