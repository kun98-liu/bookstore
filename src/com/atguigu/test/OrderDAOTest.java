package com.atguigu.test;

import com.atguigu.dao.OrderDAO;
import com.atguigu.dao.impl.OrderDAOImpl;
import com.atguigu.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author LIU JIANKUN
 * @create 2021-09-23 13:16
 */
public class OrderDAOTest {
    OrderDAO orderDAO = new OrderDAOImpl();
    @Test
    public void saveOrder() {
        orderDAO.saveOrder(new Order("1234567890",new Date(),new BigDecimal(100),0,1));

    }
}