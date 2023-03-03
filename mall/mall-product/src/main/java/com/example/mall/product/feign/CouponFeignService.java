package com.example.mall.product.feign;

import com.example.common.to.SkuReductionTo;
import com.example.common.to.SpuBoundTo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.common.utils.R;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author dai17
 * @create 2022-09-30 0:34
 */
@Service
@FeignClient("mall-coupon")
public interface CouponFeignService {

    @PostMapping("/coupon/spubounds/save")
    R saveSpuBounds(@RequestBody SpuBoundTo spuBoundTo);

    @PostMapping("/coupon/skufullreduction/saveinfo")
    R saveSkuReduction(@RequestBody SkuReductionTo skuReductionTo);

}
