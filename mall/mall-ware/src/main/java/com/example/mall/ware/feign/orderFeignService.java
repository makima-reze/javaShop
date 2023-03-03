package com.example.mall.ware.feign;

import com.example.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author dai17
 * @create 2022-11-14 17:23
 */
@Service
@FeignClient("mall-order")
public interface orderFeignService {

    @GetMapping(value = "/order/order/status/{orderSn}")
    R getOrderStatus(@PathVariable("orderSn") String orderSn);


}
