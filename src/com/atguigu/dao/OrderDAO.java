package com.atguigu.dao;

import com.atguigu.pojo.Order;

/**
 * @author LIU JIANKUN
 * @create 2021-09-23 13:06
 */
public interface OrderDAO {
    /**
     * 保存订单
     * @param order
     */
    int saveOrder(Order order);
}
