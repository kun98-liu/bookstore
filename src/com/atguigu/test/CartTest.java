package com.atguigu.test;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author LIU JIANKUN
 * @create 2021-09-22 20:59
 */
public class CartTest {
    Cart cart = new Cart();

    @Test
    public void addItem() {
        cart.addItem(new CartItem(1,"java从入门到放弃",1,new BigDecimal(30)));
        cart.addItem(new CartItem(1,"java从入门到放弃",1,new BigDecimal(30)));
        cart.addItem(new CartItem(2,"数据结构与算法",1,new BigDecimal(100)));

        System.out.println(cart);

    }

    @Test
    public void deleteItem() {
        cart.addItem(new CartItem(1,"java从入门到放弃",1,new BigDecimal(30)));
        cart.addItem(new CartItem(1,"java从入门到放弃",1,new BigDecimal(30)));
        cart.addItem(new CartItem(2,"数据结构与算法",1,new BigDecimal(100)));

        cart.deleteItem(1);

        System.out.println(cart);
    }

    @Test
    public void clear() {
        cart.addItem(new CartItem(1,"java从入门到放弃",1,new BigDecimal(30)));
        cart.addItem(new CartItem(1,"java从入门到放弃",1,new BigDecimal(30)));
        cart.addItem(new CartItem(2,"数据结构与算法",1,new BigDecimal(100)));

        cart.clear();

        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        cart.addItem(new CartItem(1,"java从入门到放弃",1,new BigDecimal(30)));
        cart.addItem(new CartItem(1,"java从入门到放弃",1,new BigDecimal(30)));
        cart.addItem(new CartItem(2,"数据结构与算法",1,new BigDecimal(100)));

        cart.updateCount(1, 5);

        System.out.println(cart);
    }
}