package com.atguigu.mall.cart.controller;

import com.atguigu.mall.cart.interceptor.CartInterceptor;
import com.atguigu.mall.cart.service.CartService;
import com.atguigu.mall.cart.vo.Cart;
import com.atguigu.mall.cart.vo.CartItem;
import com.atguigu.mall.cart.vo.UserInfoTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author dai17
 * @create 2022-11-09 0:48
 */

@Controller
public class CartController {

    @Autowired
    CartService cartService;


    @GetMapping("/cart.html")
    public String cartPage(Model model) throws ExecutionException, InterruptedException {
//        UserInfoTo userInfoTo = CartInterceptor.threadLocal.get();
//        System.out.println(userInfoTo.toString());
        Cart cart = cartService.getCart();
        model.addAttribute("cart",cart);
        return "cartList";
    }

    @GetMapping("/addToCart")
    public String addToCart(@RequestParam("skuId") Long skuId,
                            @RequestParam("num") Integer num,
                            Model model) throws ExecutionException, InterruptedException {
        CartItem cartItem = cartService.addToCart(skuId,num);
        model.addAttribute("item",cartItem);
        return "success";
    }


    @GetMapping("/currentUserCartItems")
    @ResponseBody
    public List<CartItem> getCurrentUserCartItems(){
        return cartService.getUserCartItems();
    }

}
