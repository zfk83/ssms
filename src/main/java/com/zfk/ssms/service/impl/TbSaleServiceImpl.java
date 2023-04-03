package com.zfk.ssms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zfk.ssms.domain.TbSale;
import com.zfk.ssms.service.TbSaleService;
import com.zfk.ssms.mapper.TbSaleMapper;
import org.springframework.stereotype.Service;

/**
* @author ZFK
* @description 针对表【tb_sale(用于记录每次销售的详细信息，例如销售编号、销售日期、销售员、商品编号、商品数量、销售金额等。这些信息可以帮助超市了解每次)】的数据库操作Service实现
* @createDate 2023-03-14 17:59:59
*/
@Service
public class TbSaleServiceImpl extends ServiceImpl<TbSaleMapper, TbSale>
    implements TbSaleService{

}




