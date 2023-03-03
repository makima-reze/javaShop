package com.example.mall.member.service.impl;

import com.example.mall.member.dao.MemberLevelDao;
import com.example.mall.member.entity.MemberLevelEntity;
import com.example.mall.vo.MemberLoginVo;
import com.example.mall.vo.RegistVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.utils.PageUtils;
import com.example.common.utils.Query;

import com.example.mall.member.dao.MemberDao;
import com.example.mall.member.entity.MemberEntity;
import com.example.mall.member.service.MemberService;


@Service("memberService")
public class MemberServiceImpl extends ServiceImpl<MemberDao, MemberEntity> implements MemberService {

    @Autowired
    MemberLevelDao memberLevelDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MemberEntity> page = this.page(
                new Query<MemberEntity>().getPage(params),
                new QueryWrapper<MemberEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void regist(RegistVo vo) {
        MemberDao memberDao = this.baseMapper;
        MemberEntity entity = new MemberEntity();

        MemberLevelEntity levelEntity = memberLevelDao.getDefaultLevel();
        entity.setLevelId(levelEntity.getId());


        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode(vo.getPassword());
        entity.setPassword(encode);
        entity.setMobile(vo.getPhone());
        entity.setUsername(vo.getUserName());
        entity.setNickname(vo.getUserName());
        memberDao.insert(entity);


    }

    @Override
    public MemberEntity login(MemberLoginVo vo) {
        String loginacct = vo.getLoginacct();
        String password = vo.getPassword();
        MemberDao memberDao = this.baseMapper;
        MemberEntity entity = memberDao.selectOne(new QueryWrapper<MemberEntity>().eq("username", loginacct)
                .or().eq("mobile", loginacct));
        if (entity==null){
            return null;
        }else {
            String passwordDDb = entity.getPassword();
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            boolean matches = passwordEncoder.matches(password, passwordDDb);
            if(matches){
                entity.setNickname(loginacct);
                return entity;
            }else {
                return null;
            }
        }
    }

}