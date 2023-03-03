package com.example.mall.ware.dao;

import com.example.mall.ware.entity.WareSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品库存
 * 
 * @author dai
 * @email dai17749861282@163.com
 * @date 2022-09-10 00:33:45
 */
@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity> {

    Long getSkuStock(Long skuId);

    List<Long> listWareIdHasSkuStock(@Param("skuId") Long skuId);

    Long lockSkuStock(@Param("skuId") Long skuId, @Param("wareId") Long wareId, @Param("num") Integer num);

    void unLockStock(@Param("skuId") Long skuId, @Param("wareId") Long wareId, @Param("num") Integer num);

}
