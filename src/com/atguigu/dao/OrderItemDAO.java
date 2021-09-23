package com.atguigu.dao;

import com.atguigu.pojo.OrderItem;

/**
 * @author LIU JIANKUN
 * @create 2021-09-23 13:07
 */
public interface OrderItemDAO {

    /**
     * 保存订单项
     * @param orderItem
     */
    int saveOrderItem(OrderItem orderItem);
}
