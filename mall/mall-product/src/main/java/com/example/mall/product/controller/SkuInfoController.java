package com.example.mall.product.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.mall.product.entity.SkuInfoEntity;
import com.example.mall.product.service.SkuInfoService;
import com.example.common.utils.PageUtils;
import com.example.common.utils.R;



/**
 * sku信息
 *
 * @author dai
 * @email dai17749861282@163.com
 * @date 2022-09-05 23:48:57
 */
@RestController
@RequestMapping("product/skuinfo")
public class SkuInfoController {


    @Autowired
    private SkuInfoService skuInfoService;

    @GetMapping("/{skuId}/price")
    public R getPrice(@PathVariable("skuId")Long skuId){
        SkuInfoEntity byId = skuInfoService.getById(skuId);
        return R.ok().setData(byId.getPrice().toString());
    }


    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = skuInfoService.queryPageByCondition(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{skuId}")
    public R info(@PathVariable("skuId") Long skuId){
		SkuInfoEntity skuInfo = skuInfoService.getById(skuId);

        return R.ok().put("skuInfo", skuInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SkuInfoEntity skuInfo){
		skuInfoService.save(skuInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SkuInfoEntity skuInfo){
		skuInfoService.updateById(skuInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] skuIds){
		skuInfoService.removeByIds(Arrays.asList(skuIds));

        return R.ok();
    }

}
