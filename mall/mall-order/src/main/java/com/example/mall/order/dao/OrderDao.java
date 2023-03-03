package com.example.mall.order.dao;

import com.example.mall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author dai
 * @email dai17749861282@163.com
 * @date 2022-09-10 00:30:16
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
