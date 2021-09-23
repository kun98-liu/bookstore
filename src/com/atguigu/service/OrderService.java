package com.atguigu.service;

import com.atguigu.pojo.Cart;

/**
 * @author LIU JIANKUN
 * @create 2021-09-23 13:24
 */
public interface OrderService {

    String creatOrder(Cart cart, Integer userId);
}
