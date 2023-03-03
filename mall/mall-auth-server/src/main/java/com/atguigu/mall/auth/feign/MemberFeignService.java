package com.atguigu.mall.auth.feign;

import com.atguigu.mall.auth.vo.UserLoginVo;
import com.atguigu.mall.auth.vo.UserRegistVo;
import com.example.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author dai17
 * @create 2022-11-07 20:12
 */
@Service
@FeignClient("mall-member")
public interface MemberFeignService {

    @PostMapping("/member/member/regist")
    R regist(@RequestBody UserRegistVo vo);

    @PostMapping("/member/member/login")
    R login(@RequestBody UserLoginVo vo);

}
