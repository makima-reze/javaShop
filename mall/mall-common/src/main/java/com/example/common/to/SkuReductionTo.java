package com.example.common.to;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author dai17
 * @create 2022-09-30 22:06
 */
@Data
public class SkuReductionTo {
    private Long skuId;
    private int fullCount;
    private BigDecimal discount;
    private int countStatus;
    private BigDecimal fullPrice;
    private BigDecimal reducePrice;
    private int priceStatus;
    private List<MemberPrice> memberPrice;

}
