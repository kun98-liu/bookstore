package com.atguigu.test;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;


/**
 * @author LIU JIANKUN
 * @create 2021-09-12 23:39
 */
public class BookServiceTest {
    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"药","鲁迅",new BigDecimal(55.50),200,200,null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(20);
    }

    @Test
    public void update() {
        bookService.update(new Book(19,"活着","余华",new BigDecimal(25),30,100,null));
    }

    @Test
    public void queryBookById() {
        Book book = bookService.queryBookById(16);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookService.queryBooks();
        for(Book book: books){
            System.out.println(book);
        }
    }

    @Test
    public void page() {
        Page<Book> page = bookService.page(1, 4);
        System.out.println(page);
    }

    @Test
    public void pageByPrice() {
        Page<Book> page = bookService.pageByPrice(1, Page.PAGE_SIZE, 10, 30);
        System.out.println(page);
    }
}