package com.example.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.utils.PageUtils;
import com.example.mall.product.entity.CategoryEntity;
import com.example.mall.product.vo.Catelog2Vo;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author dai
 * @email dai17749861282@163.com
 * @date 2022-09-05 22:59:58
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> ListWithTree();

    void removeMenuByIds(List<Long> longs);

    Long[] findCategoryPath(Long catelogId);

    void updateCascade(CategoryEntity category);

    Map<String, List<Catelog2Vo>> getCatalogJson();

    List<CategoryEntity> getLevel1Categorys();

    Long[] findCatelogPath(Long catelogId);

}

