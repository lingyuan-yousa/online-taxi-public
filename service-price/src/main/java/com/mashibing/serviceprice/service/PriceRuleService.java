package com.mashibing.serviceprice.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mashibing.internalcommon.constant.CommonStatusEnum;
import com.mashibing.internalcommon.dto.PriceRule;
import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.serviceprice.mapper.PriceRuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 周子涵
 * @since 2023-07-14
 */
@Service
public class PriceRuleService {

    @Autowired
    PriceRuleMapper priceRuleMapper;

    public ResponseResult add(PriceRule priceRule) {

        // 拼接fareType
        String cityCode = priceRule.getCityCode();
        String vehicleType = priceRule.getVehicleType();
        String fareType = cityCode + "$" + vehicleType;
        priceRule.setFareType(fareType);

        // 追加版本号
        QueryWrapper<PriceRule> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("city_code", cityCode);
        queryWrapper.eq("vehicle_type", vehicleType);
        queryWrapper.orderByDesc("fare_version");

        List<PriceRule> priceRules = priceRuleMapper.selectList(queryWrapper);

        Integer fareVersion = 0;
        if (priceRules.size() > 0) {
            return ResponseResult.fail(CommonStatusEnum.PRICE_RULE_EXISTS.getCode(), CommonStatusEnum.PRICE_RULE_EXISTS.getValue());
        }
        priceRule.setFareVersion(++fareVersion);

        priceRuleMapper.insert(priceRule);

        return ResponseResult.success("");
    }

    public ResponseResult edit(PriceRule priceRule) {
        // 拼接fareType
        String cityCode = priceRule.getCityCode();
        String vehicleType = priceRule.getVehicleType();
        String fareType = cityCode + "$" + vehicleType;
        priceRule.setFareType(fareType);

        // 追加版本号
        QueryWrapper<PriceRule> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("city_code", cityCode);
        queryWrapper.eq("vehicle_type", vehicleType);
        queryWrapper.orderByDesc("fare_version");

        List<PriceRule> priceRules = priceRuleMapper.selectList(queryWrapper);

        Integer fareVersion = 0;
        if (priceRules.size() > 0) {
            PriceRule lasterPriceRule = priceRules.get(0);
            Double unitPricePerMile = lasterPriceRule.getUnitPricePerMile();
            Double unitPricePerMinute = lasterPriceRule.getUnitPricePerMinute();
            Double startFare = lasterPriceRule.getStartFare();
            Integer startMile = lasterPriceRule.getStartMile();

            if (unitPricePerMile.doubleValue() == priceRule.getUnitPricePerMile().doubleValue()
            && unitPricePerMinute.doubleValue() == priceRule.getUnitPricePerMinute().doubleValue()
            && startFare.doubleValue() == priceRule.getStartFare().doubleValue()
            && startMile.intValue() == priceRule.getStartMile().intValue()) {
                return ResponseResult.fail(CommonStatusEnum.PRICE_RULE_NOT_EDIT.getCode(), CommonStatusEnum.PRICE_RULE_NOT_EDIT.getValue());
            }

            fareVersion = lasterPriceRule.getFareVersion();
        }
        priceRule.setFareVersion(++fareVersion);

        priceRuleMapper.insert(priceRule);

        return ResponseResult.success("");
    }

}
