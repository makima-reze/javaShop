package com.example.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.utils.PageUtils;
import com.example.mall.product.entity.SpuInfoDescEntity;

import java.util.List;
import java.util.Map;

/**
 * spu信息介绍
 *
 * @author dai
 * @email dai17749861282@163.com
 * @date 2022-09-05 22:59:58
 */
public interface SpuInfoDescService extends IService<SpuInfoDescEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveSpuInfoDesc(SpuInfoDescEntity spuInfoDescEntity);

}

