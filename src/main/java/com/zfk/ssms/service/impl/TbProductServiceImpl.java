package com.zfk.ssms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zfk.ssms.domain.TbProduct;
import com.zfk.ssms.service.TbProductService;
import com.zfk.ssms.mapper.TbProductMapper;
import org.springframework.stereotype.Service;

/**
* @author ZFK
* @description 针对表【tb_product(用于存储和管理超市的商品信息，包括商品名称、价格、生产商、生产日期、保质期、分类、库存数量、销售量等。通过对商品表的管理)】的数据库操作Service实现
* @createDate 2023-03-13 18:07:31
*/
@Service
public class TbProductServiceImpl extends ServiceImpl<TbProductMapper, TbProduct>
    implements TbProductService{

}




