package com.zfk.ssms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zfk.ssms.domain.TbPurchase;
import com.zfk.ssms.service.TbPurchaseService;
import com.zfk.ssms.mapper.TbPurchaseMapper;
import org.springframework.stereotype.Service;

/**
* @author ZFK
* @description 针对表【tb_purchase(用于记录超市采购商品的相关信息，包括商品名称、数量、价格、供应商信息、采购时间等。采购表的作用是帮助超市管理人员实时了解)】的数据库操作Service实现
* @createDate 2023-03-13 18:07:31
*/
@Service
public class TbPurchaseServiceImpl extends ServiceImpl<TbPurchaseMapper, TbPurchase>
    implements TbPurchaseService{

}




