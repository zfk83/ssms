package com.zfk.ssms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zfk.ssms.domain.TbGroup;
import com.zfk.ssms.domain.TbProduct;
import com.zfk.ssms.dto.ProductDTO;
import com.zfk.ssms.service.TbGroupService;
import com.zfk.ssms.service.TbProductService;
import com.zfk.ssms.mapper.TbProductMapper;
import com.zfk.ssms.service.TbProviderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
* @author ZFK
* @description 针对表【tb_product(用于存储和管理超市的商品信息，包括商品名称、价格、生产商、生产日期、保质期、分类、库存数量、销售量等。通过对商品表的管理)】的数据库操作Service实现
* @createDate 2023-04-03 20:10:56
*/
@Service
public class TbProductServiceImpl extends ServiceImpl<TbProductMapper, TbProduct>
    implements TbProductService{
    @Autowired
    private TbProviderService tbProviderService;
    @Autowired
    private TbGroupService tbGroupService;

    @Override
    public List<ProductDTO> getProductList() {
        List<TbProduct> list = this.list();
        List<ProductDTO> result = list.stream().map(tbProduct -> {
            ProductDTO productDTO = new ProductDTO();
            BeanUtils.copyProperties(tbProduct, productDTO);
            productDTO.setProvider(tbProviderService.getById(tbProduct.getProviderId()).getProviderName());
            productDTO.setGroup(tbGroupService.getById(tbProduct.getGroupId()).getGroupName());
            return productDTO;
        }).collect(Collectors.toList());
        return result;
    }
}




