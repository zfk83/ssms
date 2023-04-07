package com.zfk.ssms.service;

import com.zfk.ssms.domain.TbGroup;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author ZFK
* @description 针对表【tb_group(用于管理商品的分类信息。一般来说，一个商品可能属于多个分类，而分类表可以帮助管理者更加方便地对商品进行分类和管理。分类表)】的数据库操作Service
* @createDate 2023-03-13 18:07:31
*/
public interface TbGroupService extends IService<TbGroup> {

}
