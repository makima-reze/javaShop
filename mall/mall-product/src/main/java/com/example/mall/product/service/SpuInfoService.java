package com.example.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.utils.PageUtils;
import com.example.mall.product.entity.SpuInfoEntity;
import com.example.mall.product.vo.SpuSaveVo;

import java.util.List;
import java.util.Map;

/**
 * spu信息
 *
 * @author dai
 * @email dai17749861282@163.com
 * @date 2022-09-05 22:59:58
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveSpuInfo(SpuSaveVo vo);

    void saveBaseSpuInfo(SpuInfoEntity spuInfoEntity);


    PageUtils queryPageByCondition(Map<String, Object> params);

    void up(Long spuId);

    SpuInfoEntity getSpuInfoBySkuId(Long skuId);

}

