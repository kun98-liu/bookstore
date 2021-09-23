package com.atguigu.test;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author LIU JIANKUN
 * @create 2021-09-23 13:41
 */
public class OrderServiceTest {
    private OrderService orderService = new OrderServiceImpl();

    @Test
    public void creatOrder() {
        Cart cart = new Cart();

        cart.addItem(new CartItem(1, "java从入门到放弃", 1, new BigDecimal(30)));
        cart.addItem(new CartItem(1, "java从入门到放弃", 1, new BigDecimal(30)));
        cart.addItem(new CartItem(2, "数据结构与算法", 1, new BigDecimal(100)));

        String order = orderService.creatOrder(cart, 1);
        System.out.println(order);

    }
}