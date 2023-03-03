package com.atguigu.mall.cart.Feign;

import com.example.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author dai17
 * @create 2022-11-10 20:42
 */
@Service
@FeignClient("mall-product")
public interface ProductFeignService {

    @RequestMapping("/product/skuinfo/info/{skuId}")
    R getSkuinfo(@PathVariable("skuId") Long skuId);

    @GetMapping(value = "/product/skusaleattrvalue/stringList/{skuId}")
    List<String> getSkuSaleAttrValues(@PathVariable("skuId") Long skuId);

    @GetMapping("/product/skuinfo/{skuId}/price")
    R getPrice(@PathVariable("skuId")Long skuId);
}
