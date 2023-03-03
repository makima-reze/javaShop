package com.example.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.utils.PageUtils;
import com.example.mall.member.entity.MemberReceiveAddressEntity;

import java.util.List;
import java.util.Map;

/**
 * 会员收货地址
 *
 * @author dai
 * @email dai17749861282@163.com
 * @date 2022-09-10 00:04:59
 */
public interface MemberReceiveAddressService extends IService<MemberReceiveAddressEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<MemberReceiveAddressEntity> getAddress(Long memberId);

}

