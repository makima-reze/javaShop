package com.example.mall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.example.mall.product.entity.AttrEntity;
import com.example.mall.product.service.AttrService;
import com.example.mall.product.service.CategoryService;
import com.example.mall.product.vo.AttrGroupWithAttrsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.mall.product.entity.AttrGroupEntity;
import com.example.mall.product.service.AttrGroupService;
import com.example.common.utils.PageUtils;
import com.example.common.utils.R;



/**
 * 属性分组
 *
 * @author dai
 * @email dai17749861282@163.com
 * @date 2022-09-05 23:48:57
 */
@RestController
@RequestMapping("product/attrgroup")
public class AttrGroupController {
    @Autowired
    private AttrGroupService attrGroupService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    AttrService attrService;

    @GetMapping("/{attrgroupId}/attr/relation")
    public R attrRelation(@PathVariable("attrgroupId") Long attrgroupId){
        List<AttrEntity> entities = attrService.getRelationAttr(attrgroupId);
        return R.ok().put("data",entities);
    }

    @GetMapping("/{catelogId}/withattr")
    public R getAttrGroupWithAttrs(@PathVariable("catelogId") Long catelogId){
        List<AttrGroupWithAttrsVo> vos = attrGroupService.getAttrGroupWithAttrsByCatelogId(catelogId);
        return R.ok().put("data",vos);
    }

    /**
     * 列表
     */
    @RequestMapping("/list/{catelogId}")
    public R list(@RequestParam Map<String, Object> params,
                  @PathVariable("catelogId") long catelogId){
//        PageUtils page = attrGroupService.queryPage(params);

        PageUtils page = attrGroupService.queryPage(params,catelogId);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrGroupId}")
    public R info(@PathVariable("attrGroupId") Long attrGroupId){
		AttrGroupEntity attrGroup = attrGroupService.getById(attrGroupId);
        Long catelogId = attrGroup.getCatelogId();
        Long[] path = categoryService.findCategoryPath(catelogId);
		attrGroup.setCatelogPath(path);

        return R.ok().put("attrGroup", attrGroup);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.save(attrGroup);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.updateById(attrGroup);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] attrGroupIds){
		attrGroupService.removeByIds(Arrays.asList(attrGroupIds));

        return R.ok();
    }

}
