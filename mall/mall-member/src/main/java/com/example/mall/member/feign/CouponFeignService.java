package com.example.mall.member.feign;

import com.example.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author dai17
 * @create 2022-09-10 13:41
 */


@Service
@FeignClient("mall-coupon")
public interface CouponFeignService {

    @RequestMapping("/coupon/coupon/member/list")
    public R membercoupons();

}
