package com.mashibing.pay;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.payment.page.models.AlipayTradePagePayResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/alipay")
@Controller
@ResponseBody
public class AlipayController {

    @GetMapping("/pay")
    public String pay(String subject, String outTradeNo, String totalAmount) {
        AlipayTradePagePayResponse response;
//        localhost:9001/alipay/pay?subject=车费1&outTradeNo=1003&totalAmount=150

        try {
            response = Factory.Payment.Page().pay(subject, outTradeNo, totalAmount, "");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return response.getBody();
    }

    @PostMapping("/notify")
    public String notify(HttpServletRequest request) throws Exception {

        System.out.println("支付宝回调 notify");

        String tradeStatus = request.getParameter("trade_status");

        if (tradeStatus.trim().equals("TRADE_SUCCESS")) {
            Map<String, String> param = new HashMap<>();

            Map<String, String[]> parameterMap = request.getParameterMap();
            for (String name : parameterMap.keySet()) {
                param.put(name, request.getParameter(name));
            }

            if (Factory.Payment.Common().verifyNotify(param)) {

                System.out.println("通过支付宝的验证");

                for (String name : param.keySet()) {
                    System.out.println("收到并且接收好的参数");
                    System.out.println(name + "," + param.get(name));
                }
            } else {

                System.out.println("支付宝验证 不通过");
            }

        }

        return "success";
    }
}

