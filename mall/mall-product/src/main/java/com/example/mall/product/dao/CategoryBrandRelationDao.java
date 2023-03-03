package com.example.mall.product.dao;

import com.example.mall.product.entity.CategoryBrandRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 品牌分类关联
 * 
 * @author dai
 * @email dai17749861282@163.com
 * @date 2022-09-05 22:59:58
 */
@Mapper
public interface CategoryBrandRelationDao extends BaseMapper<CategoryBrandRelationEntity> {

    void updateCatgory(@Param("catId") Long catId,@Param("name") String name);
}
