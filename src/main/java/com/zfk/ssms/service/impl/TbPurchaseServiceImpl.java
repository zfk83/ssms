package com.zfk.ssms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zfk.ssms.domain.TbProduct;
import com.zfk.ssms.domain.TbProvider;
import com.zfk.ssms.domain.TbPurchase;
import com.zfk.ssms.dto.PurchaseDTO;
import com.zfk.ssms.service.TbProductService;
import com.zfk.ssms.service.TbProviderService;
import com.zfk.ssms.service.TbPurchaseService;
import com.zfk.ssms.mapper.TbPurchaseMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
* @author ZFK
* @description 针对表【tb_purchase(用于记录超市采购商品的相关信息，包括商品名称、数量、价格、供应商信息、采购时间等。采购表的作用是帮助超市管理人员实时了解)】的数据库操作Service实现
* @createDate 2023-03-13 18:07:31
*/
@Service
public class TbPurchaseServiceImpl extends ServiceImpl<TbPurchaseMapper, TbPurchase>
    implements TbPurchaseService{
    @Autowired
    private TbProductService tbProductService;
    @Autowired
    private TbProviderService tbProviderService;

    @Override
    public List<PurchaseDTO> getPurchaseList() {
        List<TbPurchase> list = this.list();
        List<PurchaseDTO> result = list.stream().map(tbPurchase -> {
            PurchaseDTO purchaseDTO = new PurchaseDTO();
            BeanUtils.copyProperties(tbPurchase, purchaseDTO);
            TbProduct tbProduct = tbProductService.getById(tbPurchase.getProductId());
            if(tbProduct != null){
                purchaseDTO.setProductName(tbProduct.getProductName());
            }
            TbProvider tbProvider = tbProviderService.getById(tbPurchase.getProviderId());
            if(tbProvider != null){
                purchaseDTO.setProviderName(tbProvider.getProviderName());
            }
            return purchaseDTO;
        }).collect(Collectors.toList());
        return result;
    }

    @Override
    public boolean savePurchase(PurchaseDTO purchaseDTO) {
        TbPurchase tbPurchase = new TbPurchase();
        BeanUtils.copyProperties(purchaseDTO, tbPurchase);
        LambdaQueryWrapper<TbProvider> providerLambdaQueryWrapper = new LambdaQueryWrapper<>();
        TbProvider tbProvider = tbProviderService.getOne(providerLambdaQueryWrapper.eq(TbProvider::getProviderName, purchaseDTO.getProviderName()));
        if(tbProvider != null) {
            tbPurchase.setProviderId(tbProvider.getProviderId());
        }
        return this.save(tbPurchase);
    }

    @Override
    public PurchaseDTO getPurchaseById(Long purchaseId) {
        PurchaseDTO purchaseDTO = new PurchaseDTO();
        TbPurchase purchase = this.getById(purchaseId);
        BeanUtils.copyProperties(purchase, purchaseDTO);
        TbProvider tbProvider = tbProviderService.getById(purchase.getProviderId());
        if(tbProvider != null){
            purchaseDTO.setProviderName(tbProvider.getProviderName());
        }
        return purchaseDTO;
    }

    @Override
    public boolean updatePurchase(PurchaseDTO purchaseDTO) {
        TbPurchase tbPurchase = new TbPurchase();
        BeanUtils.copyProperties(purchaseDTO, tbPurchase);
        LambdaQueryWrapper<TbProvider> providerLambdaQueryWrapper = new LambdaQueryWrapper<>();
        TbProvider tbProvider = tbProviderService.getOne(providerLambdaQueryWrapper.eq(TbProvider::getProviderName, purchaseDTO.getProviderName()));
        if(tbProvider != null) {
            tbPurchase.setProviderId(tbProvider.getProviderId());
        }
        this.updateById(tbPurchase);
        return true;
    }


}




