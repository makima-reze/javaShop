package com.example.mall.coupon.dao;

import com.example.mall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author dai
 * @email dai17749861282@163.com
 * @date 2022-09-09 23:50:57
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
