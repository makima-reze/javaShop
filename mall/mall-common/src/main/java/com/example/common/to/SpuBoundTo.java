package com.example.common.to;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author dai17
 * @create 2022-09-30 0:42
 */

@Data
public class SpuBoundTo {

    private Long spuId;

    private BigDecimal buyBounds;

    private BigDecimal growBounds;

}
