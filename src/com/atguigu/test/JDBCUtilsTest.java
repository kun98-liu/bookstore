package com.atguigu.test;

import com.atguigu.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author LIU JIANKUN
 * @create 2021-09-03 23:03
 */
public class JDBCUtilsTest {

    @Test
    public void tesyJDBCUtils() throws SQLException {
        for (int i = 0; i < 100; i++) {
            Connection connection = JDBCUtils.getConnection();
            System.out.println(connection);
            JDBCUtils.closeResource(connection);
        }
    }
}
