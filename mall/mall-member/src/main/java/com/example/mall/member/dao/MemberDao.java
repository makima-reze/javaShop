package com.example.mall.member.dao;

import com.example.mall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author dai
 * @email dai17749861282@163.com
 * @date 2022-09-10 00:04:59
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
