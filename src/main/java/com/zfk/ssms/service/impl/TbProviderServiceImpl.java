package com.zfk.ssms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zfk.ssms.domain.TbProvider;
import com.zfk.ssms.service.TbProviderService;
import com.zfk.ssms.mapper.TbProviderMapper;
import org.springframework.stereotype.Service;

/**
* @author ZFK
* @description 针对表【tb_provider(用于记录供应商相关信息，例如供应商名称、联系方式、地址、账户信息等。在系统中，采购人员可以根据需要添加、编辑或删除供应商)】的数据库操作Service实现
* @createDate 2023-03-13 18:07:31
*/
@Service
public class TbProviderServiceImpl extends ServiceImpl<TbProviderMapper, TbProvider>
    implements TbProviderService{

}




