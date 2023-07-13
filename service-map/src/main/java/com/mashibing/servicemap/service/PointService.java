package com.mashibing.servicemap.service;

import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.request.PointsRequest;
import com.mashibing.servicemap.remote.PointClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointService {

    @Autowired
    PointClient pointClient;

    public ResponseResult upload(PointsRequest pointsRequest) {

        return pointClient.upload(pointsRequest);
    }
}
