package com.atguigu.test;

import com.atguigu.dao.BookDAO;
import com.atguigu.dao.impl.BookDAOImpl;
import com.atguigu.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author LIU JIANKUN
 * @create 2021-09-11 23:46
 */
public class BookDAOTest {
    private BookDAO bookDAO = new BookDAOImpl();

    @Test
    public void addBook() {
        bookDAO.addBook(new Book(null,"狂人日记","鲁迅",new BigDecimal(55.50),200,200,null));
    }

    @Test
    public void deleteBookById() {
        bookDAO.deleteBookById(4);
    }

    @Test
    public void updateBook() {
        bookDAO.updateBook(new Book(21,"阿Q正传","鲁迅",new BigDecimal(100),100,300,null));
    }

    @Test
    public void queryBookById() {
        Book book = bookDAO.queryBookById(21);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookDAO.queryBooks();
        for(Book book: books){
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotal() {
        Integer pageTotal = bookDAO.queryForPageTotal();
        System.out.println(pageTotal);
    }

    @Test
    public void queryForPageItems() {
        List<Book> books = bookDAO.queryForPageItems(1, 4);
        for(Book book:books){
            System.out.println(book);
        }
    }


    @Test
    public void queryForPageTotalByPrice() {
        Integer queryForPageTotalByPrice = bookDAO.queryForPageTotalByPrice(10, 30);
        System.out.println(queryForPageTotalByPrice);
    }

    @Test
    public void queryForPageItemsByPrice() {
        List<Book> books = bookDAO.queryForPageItemsByPrice(0, 4, 10, 30);
        for(Book book:books){
            System.out.println(book);
        }
    }
}