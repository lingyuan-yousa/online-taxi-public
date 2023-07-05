package com.mashibing.apiBoss.service;

import com.mashibing.apiBoss.remote.ServiceDriverUserClient;
import com.mashibing.internalcommon.dto.DriverUser;
import com.mashibing.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Driver;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class DriverUserService {

    @Autowired
    private ServiceDriverUserClient serviceDriverUserClient;

    /**
     * 添加司机
     * @param driverUser
     * @return
     */
    public ResponseResult addDriverUser(DriverUser driverUser) {

        return serviceDriverUserClient.addDriverUser(driverUser);
    }

    /**
     * 修改司机
     * @param driverUser
     * @return
     */
    public ResponseResult updateDriverUser(DriverUser driverUser) {

        return serviceDriverUserClient.updateDriverUser(driverUser);
    }
}
