package com.atguigu.mall.cart.interceptor;

import com.atguigu.mall.cart.vo.UserInfoTo;
import com.example.common.vo.MemberResponseVo;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @author dai17
 * @create 2022-11-09 15:06
 */

public class CartInterceptor implements HandlerInterceptor{

    public static ThreadLocal<UserInfoTo> threadLocal = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        UserInfoTo userInfoTo = new UserInfoTo();
        HttpSession session = request.getSession();
        MemberResponseVo memberResponseVo = (MemberResponseVo) session.getAttribute("loginUser");
        if(memberResponseVo!=null){
            userInfoTo.setUserId(memberResponseVo.getId());
        }else {
            Cookie[] cookies = request.getCookies();
            if(cookies!=null&&cookies.length>0){
                for (Cookie cookie:cookies){
                    String name = cookie.getName();
                    if(name.equals("user-key")){
                        userInfoTo.setUserKey(cookie.getValue());
                        userInfoTo.setTempUser(true);
                    }
                }
            }

        }
        if(StringUtils.isEmpty(userInfoTo.getUserKey())){
            String uuid = UUID.randomUUID().toString();
            userInfoTo.setUserKey(uuid);
        }
        threadLocal.set(userInfoTo);

        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        UserInfoTo userInfoTo = threadLocal.get();
        if(!userInfoTo.isTempUser()){
            Cookie cookie = new Cookie("user-key", userInfoTo.getUserKey());
            cookie.setDomain("mall.com");
            cookie.setMaxAge(60*60*24);
            response.addCookie(cookie);
        }
    }
}
