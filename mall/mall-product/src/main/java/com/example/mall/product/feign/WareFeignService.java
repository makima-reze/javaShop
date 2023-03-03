package com.example.mall.product.feign;

import com.example.common.to.SkuHasStockVo;
import com.example.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author dai17
 * @create 2022-10-16 12:13
 */
@Service
@FeignClient("mall-ware")
public interface WareFeignService {
    @PostMapping("/ware/waresku/hasstock")
    R getSkusHasStock(@RequestBody List<Long> skuIds);

}
