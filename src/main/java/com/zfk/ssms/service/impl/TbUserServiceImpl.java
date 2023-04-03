package com.zfk.ssms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zfk.ssms.domain.TbUser;
import com.zfk.ssms.service.TbUserService;
import com.zfk.ssms.mapper.TbUserMapper;
import org.springframework.stereotype.Service;

/**
* @author ZFK
* @description 针对表【tb_user(是系统中的重要数据源，所有的用户信息都可以在这个表中进行查找和管理，包括用户的基本信息、账号信息、交易记录、积分信息等等)】的数据库操作Service实现
* @createDate 2023-03-14 12:37:28
*/
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser>
    implements TbUserService{

}




