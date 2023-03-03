package com.example.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.utils.PageUtils;
import com.example.mall.product.entity.BrandEntity;



import java.util.Map;

/**
 * 品牌
 *
 * @author dai
 * @email dai17749861282@163.com
 * @date 2022-09-05 22:59:58
 */

public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void updateDetail(BrandEntity brand);
}

