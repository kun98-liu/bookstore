package com.atguigu.dao;

import com.atguigu.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author LIU JIANKUN
 * @create 2021-09-03 23:10
 */
public abstract class BaseDAO {

    private QueryRunner queryRunner = new QueryRunner();

    /**
     * 增删改操作
     *
     * @param sql
     * @param args
     * @return
     */
    public int update(String sql, Object... args) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            int update = queryRunner.update(conn, sql, args);
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public <T> T queryForOne(Class<T> type, String sql, Object... args) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            return queryRunner.query(conn, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    public <T> List<T> queryForList(Class<T> type, String sql, Object... args) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            return queryRunner.query(conn, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    public Object queryForValue(String sql, Object...args){
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            return queryRunner.query(conn, sql, new ScalarHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }


}
