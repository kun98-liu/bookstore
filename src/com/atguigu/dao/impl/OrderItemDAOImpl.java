package com.atguigu.dao.impl;

import com.atguigu.dao.BaseDAO;
import com.atguigu.dao.OrderItemDAO;
import com.atguigu.pojo.OrderItem;

/**
 * @author LIU JIANKUN
 * @create 2021-09-23 13:08
 */
public class OrderItemDAOImpl extends BaseDAO implements OrderItemDAO {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(`id`,`name`,`count`,`price`,`total_price`,`order_id`) values(?,?,?,?,?,?)";
        return update(sql, orderItem.getId(),orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }
}
