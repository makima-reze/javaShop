package com.example.mall.product.controller;

import java.util.Arrays;
import java.util.Map;

import com.example.mall.product.vo.AttrRespVo;
import com.example.mall.product.vo.AttrVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.mall.product.entity.AttrEntity;
import com.example.mall.product.service.AttrService;
import com.example.common.utils.PageUtils;
import com.example.common.utils.R;



/**
 * 商品属性
 *
 * @author dai
 * @email dai17749861282@163.com
 * @date 2022-09-05 23:48:57
 */
@RestController
@RequestMapping("product/attr")
public class AttrController {
    @Autowired
    private AttrService attrService;

    @GetMapping("/{attrtype}/list/{catelogId}")
    public R baseAttrList(@RequestParam Map<String, Object> params,
                          @PathVariable("catelogId") Long catelogId,
                          @PathVariable("attrtype") String type){
        PageUtils page = attrService.queryBaseAttrPage(params,catelogId,type);
        return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = attrService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrId}")
    public R info(@PathVariable("attrId") Long attrId){
//		AttrEntity attr = attrService.getById(attrId);

        AttrRespVo respVo = attrService.getAttrInfo(attrId);

        return R.ok().put("attr", respVo);

//        return R.ok().put("attr", attr);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AttrVo attr){
		attrService.saveAttr(attr);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody AttrEntity attr){
		attrService.updateById(attr);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] attrIds){
		attrService.removeByIds(Arrays.asList(attrIds));

        return R.ok();
    }

}
