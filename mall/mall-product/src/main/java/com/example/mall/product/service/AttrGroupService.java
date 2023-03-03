package com.example.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.utils.PageUtils;
import com.example.mall.product.entity.AttrGroupEntity;
import com.example.mall.product.vo.AttrGroupWithAttrsVo;
import com.example.mall.product.vo.SpuItemAttrGroupVo;

import java.util.List;
import java.util.Map;

/**
 * 属性分组
 *
 * @author dai
 * @email dai17749861282@163.com
 * @date 2022-09-05 22:59:58
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPage(Map<String, Object> params, long catelogId);

    List<AttrGroupWithAttrsVo> getAttrGroupWithAttrsByCatelogId(Long catelogId);

    List<SpuItemAttrGroupVo> getAttrGroupWithAttrsBySpuId(Long spuId, Long catalogId);

}

