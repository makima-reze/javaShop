package com.atguigu.mall.cart.vo;

import lombok.Data;
import lombok.ToString;

/**
 * @author dai17
 * @create 2022-11-09 15:11
 */
@ToString
@Data
public class UserInfoTo {
    private Long userId;
    private String userKey;
    private boolean tempUser=false;

}
