package com.example.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.utils.PageUtils;
import com.example.mall.ware.entity.PurchaseDetailEntity;

import java.util.Map;

/**
 * 
 *
 * @author dai
 * @email dai17749861282@163.com
 * @date 2022-09-10 00:33:45
 */
public interface PurchaseDetailService extends IService<PurchaseDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

