package com.example.mall.product.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author dai17
 * @create 2022-09-24 23:00
 */

@Configuration
@EnableTransactionManagement
@MapperScan("com.example.mall.product.dao")
public class MybatisConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        // 这里就是分页插件的配置了，由于由@Configuration注解，所以是自动注入的，自动应用
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }


}
