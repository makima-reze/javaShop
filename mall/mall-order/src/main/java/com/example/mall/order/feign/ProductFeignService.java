package com.example.mall.order.feign;

import com.example.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author dai17
 * @create 2022-11-13 17:21
 */
@Service
@FeignClient("mall-product")
public interface ProductFeignService {

    @GetMapping("/product/spuinfo/skuId/{id}")
    R getSpuInfoBySkuId(@PathVariable("id") Long skuId);

}
