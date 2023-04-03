package com.zfk.ssms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zfk.ssms.domain.TbOrderDetail;
import com.zfk.ssms.service.TbOrderDetailService;
import com.zfk.ssms.mapper.TbOrderDetailMapper;
import org.springframework.stereotype.Service;

/**
* @author ZFK
* @description 针对表【tb_order_detail(用于记录每个订单中所购买商品的详细信息的表。它和订单表之间是一对多的关系，即一个订单可以对应多条订单明细记录，每条记录代)】的数据库操作Service实现
* @createDate 2023-03-14 15:46:42
*/
@Service
public class TbOrderDetailServiceImpl extends ServiceImpl<TbOrderDetailMapper, TbOrderDetail>
    implements TbOrderDetailService{

}




