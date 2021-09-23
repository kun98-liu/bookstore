package com.atguigu.service.impl;

import com.atguigu.dao.BookDAO;
import com.atguigu.dao.impl.BookDAOImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;

import java.util.List;

/**
 * @author LIU JIANKUN
 * @create 2021-09-12 23:36
 */
public class BookServiceImpl implements BookService {
    private BookDAO bookDAO = new BookDAOImpl();

    @Override
    public void addBook(Book book) {
        bookDAO.addBook(book);

    }

    @Override
    public void deleteBookById(Integer id) {
        bookDAO.deleteBookById(id);

    }

    @Override
    public void update(Book book) {
        bookDAO.updateBook(book);

    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDAO.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDAO.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();
        Integer pageTotalCount = bookDAO.queryForPageTotal();
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize != 0) {
            pageTotal++;
        }

        page.setPageSize(pageSize);
        page.setPageTotalCount(pageTotalCount);
        page.setPageTotal(pageTotal);

        page.setPageNo(pageNo);
        int begin = (page.getPageNo() - 1) * pageSize;
        List<Book> items = bookDAO.queryForPageItems(begin, pageSize);
        page.setItems(items);

        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<>();
        Integer pageTotalCount = bookDAO.queryForPageTotalByPrice(min,max);
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize != 0) {
            pageTotal++;
        }

        page.setPageSize(pageSize);
        page.setPageTotalCount(pageTotalCount);
        page.setPageTotal(pageTotal);

        page.setPageNo(pageNo);
        int begin = (page.getPageNo() - 1) * pageSize;
        List<Book> items = bookDAO.queryForPageItemsByPrice(begin, pageSize,min,max);
        page.setItems(items);

        return page;
    }


}
