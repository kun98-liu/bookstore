package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author LIU JIANKUN
 * @create 2021-09-22 21:23
 */
public class CartServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();


    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数：商品编号]
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        //调用bookService得到商品信息
        Book book = bookService.queryBookById(id);

        //把商品信息转化为CartItem项
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice());

        //调用Cart.addItem(CartItem)

        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);

        req.getSession().setAttribute("lastName", cartItem.getName());

        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("totalCount", cart.getTotalCount());
        resultMap.put("lastName", cartItem.getName());

        Gson gson = new Gson();
        String json = gson.toJson(resultMap);
        resp.getWriter().write(json);
    }

    /**
     * 加入购物车
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数：商品编号]
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        //调用bookService得到商品信息
        Book book = bookService.queryBookById(id);

        //把商品信息转化为CartItem项
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice());

        //调用Cart.addItem(CartItem)

        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);
        //重定向回列表页面
        resp.sendRedirect(req.getHeader("Referer"));

        req.getSession().setAttribute("lastName", cartItem.getName());
    }

    /**
     * 删除商品项
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart != null) {
            cart.deleteItem(id);
        }

        resp.sendRedirect(req.getHeader("Referer"));

    }

    /**
     * 清空购物车
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart != null) {
            cart.clear();
        }

        resp.sendRedirect(req.getHeader("Referer"));

    }

    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        int count = WebUtils.parseInt(req.getParameter("count"), 1);

        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart != null) {
            cart.updateCount(id, count);
        }

        resp.sendRedirect(req.getHeader("Referer"));

    }


}
