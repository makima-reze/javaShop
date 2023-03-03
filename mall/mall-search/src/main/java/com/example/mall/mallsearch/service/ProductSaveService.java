package com.example.mall.mallsearch.service;

import com.example.common.to.es.SkuEsModel;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @author dai17
 * @create 2022-10-16 15:31
 */

@Service
public interface ProductSaveService {
    boolean productStatusUp(List<SkuEsModel> skuEsModels) throws IOException;

}
