package com.zfk.ssms.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zfk.ssms.common.Result;
import com.zfk.ssms.domain.TbGoodsSource;
import com.zfk.ssms.service.TbGoodsSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goodsSource")
public class TbGoodsSourceController {
    @Autowired
    private TbGoodsSourceService tbGoodsSourceService;

    @GetMapping("/list")
    public Result list(Long providerId) {
        LambdaQueryWrapper<TbGoodsSource> queryWrapper = new LambdaQueryWrapper<TbGoodsSource>().eq(TbGoodsSource::getProviderId, providerId);
        return Result.success(tbGoodsSourceService.list(queryWrapper),null);
    }
}
