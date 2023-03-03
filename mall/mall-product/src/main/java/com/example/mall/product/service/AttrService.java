package com.example.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.utils.PageUtils;
import com.example.mall.product.entity.AttrEntity;
import com.example.mall.product.vo.AttrRespVo;
import com.example.mall.product.vo.AttrVo;

import java.util.List;
import java.util.Map;

/**
 * 商品属性
 *
 * @author dai
 * @email dai17749861282@163.com
 * @date 2022-09-05 22:59:58
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveAttr(AttrVo attr);

    PageUtils queryBaseAttrPage(Map<String, Object> params, Long catelogId, String type);

    List<AttrEntity> getRelationAttr(Long attrgroupId);

    List<Long> selectSearchAttrsIds(List<Long> attrIds);

    AttrRespVo getAttrInfo(Long attrId);

}

