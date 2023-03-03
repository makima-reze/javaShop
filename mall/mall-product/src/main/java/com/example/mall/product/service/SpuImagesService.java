package com.example.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.utils.PageUtils;
import com.example.mall.product.entity.SpuImagesEntity;

import java.util.List;
import java.util.Map;

/**
 * spu图片
 *
 * @author dai
 * @email dai17749861282@163.com
 * @date 2022-09-05 22:59:58
 */
public interface SpuImagesService extends IService<SpuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveImages(Long id, List<String> images);

}

