package com.zfk.ssms.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zfk.ssms.common.Result;
import com.zfk.ssms.domain.TbUser;
import com.zfk.ssms.service.TbUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author ZFK
 */

@Api
@RestController
@RequestMapping("/user")
@CrossOrigin
public class TbUserController {
    @Autowired
    private TbUserService tbUserService;

    @PostMapping("/add")
    public Result addUser(@RequestBody TbUser tbUser) {
        tbUserService.save(tbUser);
        return Result.success(null, "添加成功");
    }

    @DeleteMapping("/delete")
    public Result deleteUser(@RequestBody TbUser tbUser) {
        tbUserService.removeById(tbUser.getUserId());
        return Result.success(null, "删除成功");
    }

    @PutMapping("/update")
    public Result updateUser(@RequestBody TbUser tbUser) {
        tbUserService.updateById(tbUser);
        return Result.success(null, "更新成功");
    }

    @GetMapping("/get")
    public Result getUser(@RequestBody Long userId) {
        tbUserService.getById(userId);
        return Result.success(tbUserService.getById(userId), "查询成功");
    }

    @PostMapping("/login")
    public Result login(@RequestBody TbUser tbUser) {
        LambdaQueryWrapper<TbUser> wrapper = new LambdaQueryWrapper<TbUser>().eq(TbUser::getUserName, tbUser.getUserName());
        wrapper.eq(TbUser::getPassword, tbUser.getPassword());
        TbUser user = tbUserService.getOne(wrapper);
        System.out.println("hello");
        if (user != null) {
            return Result.success(user, "登录成功");
        } else {
            return Result.fail(null, "登录失败");
        }
    }

    @PostMapping("/register")
    public Result register(@RequestBody TbUser tbUser) {
        LambdaQueryWrapper<TbUser> wrapper = new LambdaQueryWrapper<TbUser>().eq(TbUser::getUserName, tbUser.getUserName());
        TbUser user = tbUserService.getOne(wrapper);
        if (user != null) {
            return Result.fail(null, "用户名已存在");
        } else {
            tbUserService.save(tbUser);
            return Result.success(null, "注册成功");
        }
    }
}
