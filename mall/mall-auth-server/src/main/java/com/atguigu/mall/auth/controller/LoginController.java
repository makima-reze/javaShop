package com.atguigu.mall.auth.controller;

import com.alibaba.fastjson.TypeReference;
import com.atguigu.mall.auth.feign.MemberFeignService;
import com.atguigu.mall.auth.vo.UserLoginVo;
import com.atguigu.mall.auth.vo.UserRegistVo;
import com.example.common.utils.R;
import com.example.common.vo.MemberResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;

/**
 * @author dai17
 * @create 2022-11-07 15:18
 */

@Controller
public class LoginController {

    @Autowired
    MemberFeignService memberFeignService;

    @GetMapping("/login.html")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/reg.html")
    public String regPage(){
        return "reg";
    }

    @PostMapping("/regist")
    public String regist(@Valid UserRegistVo vo, BindingResult result){
        if(result.hasErrors()){
            return "reg";
        }
        R r = memberFeignService.regist(vo);
        if(r.getcode()==0){
            return "redirect:http://auth.mall.com/login.html";
        }else {
            return "reg";
        }
    }

    @PostMapping("/login")
    public String login(UserLoginVo vo, RedirectAttributes redirectAttributes, HttpSession session){
        R login = memberFeignService.login(vo);
        if(login.getcode()==0){
            MemberResponseVo data = login.getData("data", new TypeReference<MemberResponseVo>() {});
            session.setAttribute("loginUser",data);
            return "redirect:http://mall.com";
        }else {
            HashMap<String, String> errors = new HashMap<>();
            errors.put("msg",login.getData("msg",new TypeReference<String>(){}));
            redirectAttributes.addFlashAttribute("errors",errors);
            return "redirect:http://auth.mall.com/login.html";
        }
    }

}
