package com.example.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.utils.PageUtils;
import com.example.mall.member.entity.MemberEntity;
import com.example.mall.vo.MemberLoginVo;
import com.example.mall.vo.RegistVo;

import java.util.Map;

/**
 * 会员
 *
 * @author dai
 * @email dai17749861282@163.com
 * @date 2022-09-10 00:04:59
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void regist(RegistVo vo);

    MemberEntity login(MemberLoginVo vo);

}

