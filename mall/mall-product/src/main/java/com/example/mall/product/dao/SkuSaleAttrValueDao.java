package com.example.mall.product.dao;

import com.example.mall.product.entity.SkuSaleAttrValueEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mall.product.vo.SkuItemSaleAttrVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * sku销售属性&值
 * 
 * @author dai
 * @email dai17749861282@163.com
 * @date 2022-09-05 22:59:58
 */
@Mapper
public interface SkuSaleAttrValueDao extends BaseMapper<SkuSaleAttrValueEntity> {

    List<SkuItemSaleAttrVo> getSaleAttrBySpuId(@Param("spuId") Long spuId);


    List<String> getSkuSaleAttrValuesAsStringList(@Param("skuId") Long skuId);

}
