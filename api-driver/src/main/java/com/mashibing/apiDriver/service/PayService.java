package com.mashibing.apiDriver.service;

import com.mashibing.apiDriver.remote.ServiceSsePushClient;
import com.mashibing.internalcommon.constant.IdentityConstants;
import com.mashibing.internalcommon.dto.ResponseResult;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class PayService {

    @Autowired
    ServiceSsePushClient serviceSsePushClient;

    public ResponseResult pushPayInfo(String orderId, String price, Long passengerId) {

        // 封装消息
        JSONObject message = new JSONObject();
        message.put("price", price);
        message.put("orderId", orderId);

        // 推送消息
        serviceSsePushClient.push(passengerId, IdentityConstants.PASSENGER_IDENTITY, message.toString());

        return ResponseResult.success("");
    }
}
