package com.example.mall.mallsearch.controller;

import com.example.common.to.es.SkuEsModel;
import com.example.common.utils.R;
import com.example.mall.mallsearch.service.ProductSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @author dai17
 * @create 2022-10-16 15:17
 */
@RequestMapping("/search/save")
@RestController
public class ElasticSaveController {

    @Autowired
    ProductSaveService productSaveService;

    //上架商品
    @PostMapping("/product")
    public R productStatusUp(@RequestBody List<SkuEsModel> skuEsModels){
        boolean b = false;
        try {
            b = productSaveService.productStatusUp(skuEsModels);
        } catch (IOException e) {
            return R.error(404,"商品上架异常");
        }
        if(!b)return R.ok();
        else return R.error(404,"商品上架异常");
    }
}
