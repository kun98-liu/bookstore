package com.atguigu.test;

import com.atguigu.dao.OrderItemDAO;
import com.atguigu.dao.impl.OrderItemDAOImpl;
import com.atguigu.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;


/**
 * @author LIU JIANKUN
 * @create 2021-09-23 13:17
 */
public class OrderItemDAOTest {
    OrderItemDAO orderItemDAO = new OrderItemDAOImpl();

    @Test
    public void saveOrderItem() {
        orderItemDAO.saveOrderItem(new OrderItem(2,"数据结构与算法",3,new BigDecimal(10),new BigDecimal(30),"1234567890"));
    }
}