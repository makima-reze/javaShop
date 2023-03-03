package com.example.mall.order.web;


import com.example.mall.order.service.OrderService;
import com.example.mall.order.vo.OrderConfirmVo;
import com.example.mall.order.vo.OrderSubmitVo;
import com.example.mall.order.vo.SubmitOrderResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ExecutionException;

/**
 * @Description:
 * @Created: with IntelliJ IDEA.
 * @author: 夏沫止水
 * @createTime: 2020-07-02 18:35
 **/

@Controller
public class OrderWebController {

    @Autowired
    private OrderService orderService;

    /**
     * 去结算确认页
     * @param model
     * @param request
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @GetMapping(value = "/toTrade")
    public String toTrade(Model model, HttpServletRequest request) throws ExecutionException, InterruptedException {

        OrderConfirmVo confirmVo = orderService.confirmOrder();

        model.addAttribute("confirmOrderData",confirmVo);
        //展示订单确认的数据

        return "confirm";
    }


    /**
     * 下单功能
     * @param vo
     * @return
     */
    @PostMapping(value = "/submitOrder")
    public String submitOrder(OrderSubmitVo vo,Model model) {

        SubmitOrderResponseVo responseVo = orderService.submitOrder(vo);
        if (responseVo.getCode()==0){
            model.addAttribute("submitOrderResp",responseVo);
            return "pay";
        }else {
            return "redirect:http://order.mall.com/toTrade";
        }

    }

}
