package com.mashibing.serviceDriverUser.controller;


import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.dto.DriverUserWorkStatus;
import com.mashibing.serviceDriverUser.service.DriverUserWorkStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 周子涵
 * @since 2023-07-11
 */
@RestController
public class DriverUserWorkStatusController {

    @Autowired
    DriverUserWorkStatusService driverUserWorkStatusService;

    @RequestMapping("/driver-user-work-status")
    public ResponseResult changeWorkStatus(@RequestBody DriverUserWorkStatus driverUserWorkStatus) {

        return driverUserWorkStatusService.changeWorkStatus(driverUserWorkStatus.getDriverId(), driverUserWorkStatus.getWorkStatus());
    }
}
