package com.zfk.ssms.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zfk.ssms.common.Result;
import com.zfk.ssms.domain.TbUser;
import com.zfk.ssms.service.TbUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author ZFK
 */

@Api
@RestController
@RequestMapping("/user")
public class TbUserController {
    @Autowired
    private TbUserService tbUserService;

    @PostMapping("/add")
    public Result addUser(@RequestBody TbUser tbUser) {
        boolean success = tbUserService.save(tbUser);
        return success ? Result.success(null, "添加成功") : Result.fail(null, "添加失败");
    }

    @DeleteMapping("/delete")
    public Result deleteUser(Long id) {
        tbUserService.removeById(id);
        return Result.success(null, "删除成功");
    }

    @PutMapping("/update")
    public Result updateUser(@RequestBody TbUser tbUser) {
        if (tbUserService.updateById(tbUser)) {
            return Result.success(null, "更新成功");
        } else {
            return Result.fail(null, "更新失败");
        }
    }

    @GetMapping("/get")
    public Result getUser(String userName) {
        if (StringUtils.isEmpty(userName)) {
            return Result.success(tbUserService.list(), "查询成功");
        }
        if (!StringUtils.isEmpty(userName)) {
            LambdaQueryWrapper<TbUser> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(TbUser::getUserName, userName);
            return Result.success(tbUserService.list(queryWrapper), "查询成功");
        }
        return Result.fail(null, "查询失败");
    }

    @GetMapping("/getById")
    public Result getUserById(Long id) {
        return Result.success(tbUserService.getById(id), null);
    }

    @GetMapping("/list")
    public Result listUser() {
        return Result.success(tbUserService.list(), null);
    }

    @PostMapping("/login")
    public Result login(@RequestBody TbUser tbUser) {
        LambdaQueryWrapper<TbUser> wrapper = new LambdaQueryWrapper<TbUser>().eq(TbUser::getUserName, tbUser.getUserName());
        wrapper.eq(TbUser::getPassword, tbUser.getPassword());
        TbUser user = tbUserService.getOne(wrapper);
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
