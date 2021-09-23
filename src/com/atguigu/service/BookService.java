package com.atguigu.service;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;

import java.util.List;

/**
 * @author LIU JIANKUN
 * @create 2021-09-12 23:34
 */
public interface BookService {

    void addBook(Book book);

    void deleteBookById(Integer id);

    void update(Book book);

    Book queryBookById(Integer id);

    List<Book> queryBooks();

    Page<Book> page(int pageNo, int pageSize);

    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);

}
