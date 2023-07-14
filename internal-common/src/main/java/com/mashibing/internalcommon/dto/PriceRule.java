package com.mashibing.internalcommon.dto;


import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 周子涵
 * @since 2023-07-14
 */
@Data
public class PriceRule implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 城市编号
     */
    private String cityCode;

    /**
     * 车辆类型
     */
    private String vehicleType;

    private Double startFare;

    private Integer startMile;

    private Double unitPricePerMile;

    private Double unitPricePerMinute;

    /**
     * 版本
     */
    private Integer fareVersion;

    private String fareType;

}
