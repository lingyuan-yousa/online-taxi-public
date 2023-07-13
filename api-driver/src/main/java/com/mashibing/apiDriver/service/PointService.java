package com.mashibing.apiDriver.service;

import com.mashibing.apiDriver.remote.ServiceDriverUserClient;
import com.mashibing.apiDriver.remote.ServiceMapClient;
import com.mashibing.internalcommon.dto.Car;
import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.request.ApiDriverPointRequest;
import com.mashibing.internalcommon.request.PointsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointService {

    @Autowired
    ServiceDriverUserClient serviceDriverUserClient;

    @Autowired
    ServiceMapClient serviceMapClient;

    public ResponseResult upload(ApiDriverPointRequest apiDriverPointRequest) {

        // 获取carId
        Long carId = apiDriverPointRequest.getCarId();

        // 通过carId 获取tid, trid, 调用service-driver-user接口
        ResponseResult<Car> carById = serviceDriverUserClient.getCarById(carId);
        Car car = carById.getData();
        String tid = car.getTid();
        String trid = car.getTrid();

        // 调用地图上传
        PointsRequest pointsRequest = new PointsRequest();
        pointsRequest.setTid(tid);
        pointsRequest.setTrid(trid);
        pointsRequest.setPoints(apiDriverPointRequest.getPoints());

        return serviceMapClient.upload(pointsRequest);
    }
}
