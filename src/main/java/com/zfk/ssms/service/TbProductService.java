package com.zfk.ssms.service;

import com.zfk.ssms.domain.TbProduct;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zfk.ssms.dto.ProductDTO;

import java.util.List;

/**
* @author ZFK
* @description 针对表【tb_product(用于存储和管理超市的商品信息，包括商品名称、价格、生产商、生产日期、保质期、分类、库存数量、销售量等。通过对商品表的管理)】的数据库操作Service
* @createDate 2023-04-03 20:10:56
*/
public interface TbProductService extends IService<TbProduct> {
    List<ProductDTO> getProductList();
    boolean saveProduct(ProductDTO productDTO);
}
