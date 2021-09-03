package com.beibei.controller;


import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.MD5;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.beibei.entity.BeibeiUser;
import com.beibei.service.IBeibeiUserService;
import common.ResultInfo;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 用户主表 前端控制器
 * </p>
 *
 * @author linxy
 * @since 2021-08-31
 */
@Slf4j
@RestController
@RequestMapping("/beibei/beibei-user")
public class BeibeiUserController {

    @Resource
    private IBeibeiUserService iBeibeiUserService;

    /**
     * 注册
     */
    @PostMapping("/register")
    @ResponseBody
    public ResultInfo register(BeibeiUser beibeiUser) {
        // 用户名不能重复
        String accountNo = beibeiUser.getAccountNo();
        Integer count = iBeibeiUserService.count(Wrappers.<BeibeiUser>lambdaQuery().eq(BeibeiUser::getAccountNo, accountNo));
        if (count > 0) {
            ResultInfo.error(StrUtil.format("账号{}已存在", accountNo));
        }
        // 密码加盐
        String password = beibeiUser.getPassword();
        String md5 = SecureUtil.md5(password);
        beibeiUser.setPassword(md5);
        iBeibeiUserService.save(beibeiUser);
        return ResultInfo.success(true);
    }

    /**
     * 登录
     */
    @PostMapping("/login")
    @ResponseBody
    public ResultInfo login(BeibeiUser beibeiUser) {
        //密码加盐
        String password = beibeiUser.getPassword();
        String md5 = SecureUtil.md5(password);
        BeibeiUser db = iBeibeiUserService.getOne(Wrappers.<BeibeiUser>lambdaQuery().eq(BeibeiUser::getAccountNo, beibeiUser.getAccountNo()));
        if (ObjectUtil.isEmpty(db)) {
            return ResultInfo.error("账号不存在");
        } else {
            String passwordDb = db.getPassword();
            if (md5.equals(passwordDb)) {
                return ResultInfo.success(true);
            } else {
                return ResultInfo.error("密码错误");
            }
        }
    }
}
