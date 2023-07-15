package com.mashibing.serviceprice.controller;


import com.mashibing.internalcommon.dto.PriceRule;
import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.serviceprice.service.PriceRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 周子涵
 * @since 2023-07-14
 */
@RestController
@RequestMapping("/price-rule")
public class PriceRuleController {

    @Autowired
    PriceRuleService priceRuleService;

    @PostMapping("/add")
    public ResponseResult add(@RequestBody PriceRule priceRule) {

        return priceRuleService.add(priceRule);
    }

    @PostMapping("/edit")
    public ResponseResult edit(@RequestBody PriceRule priceRule) {

        return priceRuleService.edit(priceRule);
    }

    /**
     * 查询最新的计价规则
     * @param fareType
     * @return
     */
    @GetMapping("/get-newest-version")
    public ResponseResult<PriceRule> getNewestVersion(@RequestParam String fareType) {

        return priceRuleService.getNewestVersion(fareType);
    }

    /**
     * 判断规则是否是最新
     * @param fareType
     * @param fareVersion
     * @return
     */
    @GetMapping("/is-new")
    public ResponseResult<Boolean> isNew(@RequestParam String fareType, @RequestParam Integer fareVersion) {

        return priceRuleService.isNew(fareType, fareVersion);
    }
}
