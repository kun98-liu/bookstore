package com.atguigu.dao.impl;

import com.atguigu.dao.BaseDAO;
import com.atguigu.dao.OrderDAO;
import com.atguigu.pojo.Order;

/**
 * @author LIU JIANKUN
 * @create 2021-09-23 13:08
 */
public class OrderDAOImpl extends BaseDAO implements OrderDAO {

    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status` ,`user_id`) values(?,?,?,?,?)";

        return update(sql, order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }
}
