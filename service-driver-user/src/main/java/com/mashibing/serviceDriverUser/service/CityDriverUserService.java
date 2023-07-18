package com.mashibing.serviceDriverUser.service;

import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.serviceDriverUser.mapper.DriverUserMapper;
import feign.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityDriverUserService {

    @Autowired
    DriverUserMapper driverUserMapper;

    public ResponseResult<Boolean> isAvailableDriver(String cityCode) {

        int cnt = driverUserMapper.selectDriverUserCountByCityCode(cityCode);
        if (cnt > 0) {
            return ResponseResult.success(true);
        } else {
            return ResponseResult.success(false);
        }
    }
}
