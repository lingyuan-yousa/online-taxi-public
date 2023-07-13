package com.mashibing.servicemap.controller;

import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.request.PointsRequest;
import com.mashibing.servicemap.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/point")
public class PointCtroller {

    @Autowired
    PointService pointService;

    @PostMapping("/upload")
    public ResponseResult upload(@RequestBody PointsRequest pointsRequest) {

        return pointService.upload(pointsRequest);
    }
}
