package com.atguigu.service.impl;

import com.atguigu.dao.BookDAO;
import com.atguigu.dao.OrderDAO;
import com.atguigu.dao.OrderItemDAO;
import com.atguigu.dao.impl.BookDAOImpl;
import com.atguigu.dao.impl.OrderDAOImpl;
import com.atguigu.dao.impl.OrderItemDAOImpl;
import com.atguigu.pojo.*;
import com.atguigu.service.OrderService;

import java.util.Date;
import java.util.Map;

/**
 * @author LIU JIANKUN
 * @create 2021-09-23 13:24
 */
public class OrderServiceImpl implements OrderService{
    private OrderDAO orderDAO = new OrderDAOImpl();
    private OrderItemDAO orderItemDAO = new OrderItemDAOImpl();
    private BookDAO bookDAO = new BookDAOImpl();


    @Override
    public String creatOrder(Cart cart, Integer userId) {
        String orderId = System.currentTimeMillis() + "" + userId;
        Order order = new Order(orderId,new Date(),cart.getTotalPrice(),0,userId);
        orderDAO.saveOrder(order);

        for(Map.Entry<Integer,CartItem> entry: cart.getItems().entrySet()){
            CartItem cartItem = entry.getValue();
            OrderItem orderItem = new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(),orderId);
            orderItemDAO.saveOrderItem(orderItem);

            //每添加一个订单项，就要更新库存和销量
            Book book = bookDAO.queryBookById(cartItem.getId());
            book.setSales(book.getSales() + cartItem.getCount());
            book.setStock(book.getStock() - cartItem.getCount());
            bookDAO.updateBook(book);
        }
        cart.clear();
        return orderId;
    }
}
