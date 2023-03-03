package com.atguigu.mall.cart.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.atguigu.mall.cart.Feign.ProductFeignService;
import com.atguigu.mall.cart.interceptor.CartInterceptor;
import com.atguigu.mall.cart.service.CartService;
import com.atguigu.mall.cart.vo.Cart;
import com.atguigu.mall.cart.vo.CartItem;
import com.atguigu.mall.cart.vo.SkuInfoVo;
import com.atguigu.mall.cart.vo.UserInfoTo;
import com.example.common.utils.R;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

/**
 * @author dai17
 * @create 2022-11-10 20:04
 */
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    ProductFeignService productFeignService;

    @Autowired
    ThreadPoolExecutor executor;

    private static String CART_PREFIX = "mall:cart";

    @Override
    public CartItem addToCart(Long skuId, Integer num) throws ExecutionException, InterruptedException {
        BoundHashOperations<String, Object, Object> cartOps = getCartOps();

        String res = (String) cartOps.get(skuId.toString());
        if(!StringUtils.isEmpty(res)){
            CartItem cartItem = JSON.parseObject(res, CartItem.class);
            cartItem.setCount(cartItem.getCount()+num);
            cartOps.put(skuId.toString(),JSON.toJSONString(cartItem));
            return cartItem;
        }

        CartItem cartItem = new CartItem();

        CompletableFuture<Void> getSkuInfoTask = CompletableFuture.runAsync(() -> {
            R skuInfo = productFeignService.getSkuinfo(skuId);
            SkuInfoVo data = skuInfo.getData("skuInfo", new TypeReference<SkuInfoVo>() {
            });
            cartItem.setCheck(true);
            cartItem.setCount(num);
            cartItem.setImage(data.getSkuDefaultImg());
            cartItem.setTitle(data.getSkuTitle());
            cartItem.setSkuId(skuId);
            cartItem.setPrice(data.getPrice());
        }, executor);

        CompletableFuture<Void> getSkuSaleValueAttr = CompletableFuture.runAsync(() -> {
            List<String> values = productFeignService.getSkuSaleAttrValues(skuId);
            cartItem.setSkuAttr(values);
        }, executor);

        CompletableFuture.allOf(getSkuInfoTask,getSkuSaleValueAttr).get();
        String s = JSON.toJSONString(cartItem);
        cartOps.put(skuId.toString(),s);

        return cartItem;

    }

    @Override
    public Cart getCart() throws ExecutionException, InterruptedException {
        Cart cart = new Cart();
        UserInfoTo userInfoTo = CartInterceptor.threadLocal.get();
        if(userInfoTo.getUserId()!=null){
            //登录
            String cartKey = CART_PREFIX + userInfoTo.getUserId();
            List<CartItem> tempCartItem = getCartItem(CART_PREFIX + userInfoTo.getUserKey());
            if(tempCartItem!=null){
                for (CartItem item:tempCartItem){
                    addToCart(item.getSkuId(),item.getCount());
                }
                //清除临时购物车
                clearCart(CART_PREFIX + userInfoTo.getUserKey());
            }

            List<CartItem> cartItem = getCartItem(cartKey);
            cart.setItems(cartItem);

        }else {
            String cartKey = CART_PREFIX+userInfoTo.getUserKey();
            List<CartItem> cartItem = getCartItem(cartKey);
            cart.setItems(cartItem);
        }
        return cart;
    }

    @Override
    public void clearCart(String cartKey) {
        redisTemplate.delete(cartKey);
    }

    @Override
    public List<CartItem> getUserCartItems() {
        UserInfoTo userInfoTo = CartInterceptor.threadLocal.get();
        if (userInfoTo.getUserId()==null){
            return null;
        }else {
            String cartKey = CART_PREFIX + userInfoTo.getUserId();
            List<CartItem> cartItem = getCartItem(cartKey);
            List<CartItem> collect = cartItem.stream().filter(item ->
                    item.isCheck()).map(item->{
                R price = productFeignService.getPrice(item.getSkuId());
                String data = (String) price.get("data");
                item.setPrice(new BigDecimal(data));
                        return item;
            }).collect(Collectors.toList());
            return collect;
        }
    }

    private BoundHashOperations<String, Object, Object> getCartOps() {
        UserInfoTo userInfoTo = CartInterceptor.threadLocal.get();
        String cartKey = "";
        if(userInfoTo.getUserId()!=null){
            cartKey = CART_PREFIX+userInfoTo.getUserId();
        }else {
            cartKey = CART_PREFIX+userInfoTo.getUserKey();
        }
        BoundHashOperations<String, Object, Object> operations = redisTemplate.boundHashOps(cartKey);
        return operations;
    }

    private List<CartItem> getCartItem(String cartKey){
        BoundHashOperations<String, Object, Object> hashOps = redisTemplate.boundHashOps(cartKey);
        List<Object> values = hashOps.values();
        if(values!=null&&values.size()>0){
            List<CartItem> collect = values.stream().map((obj) -> {
                String str = (String) obj;
                CartItem cartItem = JSON.parseObject(str, CartItem.class);
                return cartItem;
            }).collect(Collectors.toList());
            return collect;
        }
        return null;
    }
}
