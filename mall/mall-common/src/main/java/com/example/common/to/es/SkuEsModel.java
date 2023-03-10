package com.example.common.to.es;

import jdk.internal.util.xml.impl.Attrs;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author dai17
 * @create 2022-10-16 0:01
 */

@Data
public class SkuEsModel {
    private Long skuId;
    private Long spuId;
    private String skuTitle;
    private BigDecimal skuPrice;
    private String skuImg;
    private Long saleCount;
    private Boolean hasStock;
    private Long hotScore;
    private Long brandId;
    private Long catalogId;
    private String brandName;
    private String brandImg;
    private String catalogName;
    private List<Attrs> attrs;

    @Data
    public static class Attrs{
        private Long attrId;
        private String attrName;
        private String attrValue;
    }



}
