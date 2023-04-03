package com.zfk.ssms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zfk.ssms.domain.TbOrder;
import com.zfk.ssms.service.TbOrderService;
import com.zfk.ssms.mapper.TbOrderMapper;
import org.springframework.stereotype.Service;

/**
* @author ZFK
* @description 针对表【tb_order(用于记录超市的销售订单信息。它可以包含多个字段，如订单号、订单日期、商品信息、购买数量、购买价格、支付方式、购买者信息等)】的数据库操作Service实现
* @createDate 2023-03-14 15:46:42
*/
@Service
public class TbOrderServiceImpl extends ServiceImpl<TbOrderMapper, TbOrder>
    implements TbOrderService{

}




