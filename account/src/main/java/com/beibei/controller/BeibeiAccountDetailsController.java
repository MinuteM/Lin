package com.beibei.controller;


import cn.hutool.json.JSONUtil;
import com.beibei.entity.BeibeiAccountDetails;
import com.beibei.service.IBeibeiAccountDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * <p>
 * 账单明细 前端控制器
 * </p>
 *
 * @author linxy
 * @since 2021-08-30
 */
@RestController
@RequestMapping("/beibei/beibei-account-details")
public class BeibeiAccountDetailsController {

    @Resource
    private IBeibeiAccountDetailsService iBeibeiAccountDetailsService;

    @GetMapping("/demo")
    public String demo() {
        String returnJson = "";
        BeibeiAccountDetails beibeiAccountDetails = new BeibeiAccountDetails();
        beibeiAccountDetails.setIEType(1);
        beibeiAccountDetails.setIESubcategory(1);
        beibeiAccountDetails.setUserId(1L);
        beibeiAccountDetails.setAmount(BigDecimal.TEN);
        iBeibeiAccountDetailsService.save(beibeiAccountDetails);
        returnJson = JSONUtil.toJsonStr(beibeiAccountDetails);
        return  returnJson;
    }
}
