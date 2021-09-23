package com.atguigu.dao;

import com.atguigu.pojo.Book;

import java.util.List;

/**
 * @author LIU JIANKUN
 * @create 2021-09-11 23:20
 */
public interface BookDAO {

    int addBook(Book book);

    int deleteBookById(Integer id);

    int updateBook(Book book);

    Book queryBookById(Integer id);

    List<Book> queryBooks();

    Integer queryForPageTotal();

    Integer queryForPageTotalByPrice(int min, int max);

    List<Book> queryForPageItems(int begin, int pageSize);

    List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);

}
