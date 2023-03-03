package com.example.mall.order.feign;

import com.example.mall.order.vo.OrderItemVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author dai17
 * @create 2022-11-11 15:11
 */

@Service
@FeignClient("mall-cart")
public interface CartFeignService {

    @GetMapping("/currentUserCartItems")
    List<OrderItemVo> getCurrentUserCartItems();

}
