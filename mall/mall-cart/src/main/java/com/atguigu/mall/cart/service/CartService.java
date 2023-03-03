package com.atguigu.mall.cart.service;


import com.atguigu.mall.cart.vo.Cart;
import com.atguigu.mall.cart.vo.CartItem;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author dai17
 * @create 2022-11-10 19:53
 */

public interface CartService {


    CartItem addToCart(Long skuId, Integer num) throws ExecutionException, InterruptedException;

    Cart getCart() throws ExecutionException, InterruptedException;

    void clearCart(String cartKey);

    List<CartItem> getUserCartItems();

}
