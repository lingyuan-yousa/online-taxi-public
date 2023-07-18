package com.mashibing.internalcommon.request;

import lombok.Data;

@Data
public class PriceRuleNewRequest {

    private String fareType;

    private Integer fareVersion;
}
