package com.example.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.utils.PageUtils;
import com.example.mall.coupon.entity.UndoLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author dai
 * @email dai17749861282@163.com
 * @date 2022-09-09 23:50:56
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

