package com.atguigu.mall.auth.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author dai17
 * @create 2022-11-07 21:16
 */
@Data
public class UserLoginVo implements Serializable{
    private String loginacct;
    private String password;
}
