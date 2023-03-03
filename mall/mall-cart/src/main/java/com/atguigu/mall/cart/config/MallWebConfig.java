package com.atguigu.mall.cart.config;

import com.atguigu.mall.cart.interceptor.CartInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author dai17
 * @create 2022-11-09 15:55
 */
@Configuration
public class MallWebConfig implements WebMvcConfigurer{

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CartInterceptor()).addPathPatterns("/**");
    }
}
