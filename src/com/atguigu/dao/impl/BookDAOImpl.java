package com.atguigu.dao.impl;

import com.atguigu.dao.BaseDAO;
import com.atguigu.dao.BookDAO;
import com.atguigu.pojo.Book;

import java.util.List;

/**
 * @author LIU JIANKUN
 * @create 2021-09-11 23:22
 */
public class BookDAOImpl extends BaseDAO implements BookDAO {
    @Override
    public int addBook(Book book) {
        String sql = "INSERT INTO t_book(`name` , `author` , `price` , `sales` , `stock` , `img_path`) VALUES(?,?,?,?,?,?);";
        return update(sql, book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where `id` = ? ";
        return update(sql, id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set `name`=?,`author`=?,`price`=?,`sales`=?,`stock`=?,`img_Path`=? where `id`=?";
        return update(sql, book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath(),book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select `id`, `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book where `id`=? ";
        return queryForOne(Book.class, sql, id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select `id`,`name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book ";
        return queryForList(Book.class, sql);
    }

    @Override
    public Integer queryForPageTotal() {
        String sql = "select count(*) from t_book";
        Number value = (Number) queryForValue(sql);
        return value.intValue();
    }

    @Override
    public Integer queryForPageTotalByPrice(int min, int max) {
        String sql = "select count(*) from t_book where price between ? and ? ";
        Number value = (Number) queryForValue(sql,min,max);
        return value.intValue();
    }

    @Override
    public List<Book> queryForPageItems(int begin, int pageSize) {
        String sql = "select `id`,`name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book limit ?,?";

        return queryForList(Book.class, sql, begin,pageSize);
    }

    @Override
    public List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql = "select `id`,`name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book" +
                " where price between ? and ? order by price " +
                "limit ?,?";

        return queryForList(Book.class, sql, min,max,begin,pageSize);
    }
}
