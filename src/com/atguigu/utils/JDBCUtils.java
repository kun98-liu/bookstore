package com.atguigu.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.util.JdbcUtils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author LIU JIANKUN
 * @create 2021-09-03 0:24
 */
public class JDBCUtils {

    private static DruidDataSource dataSource;

    static {
        try {
            Properties properties = new Properties();
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(inputStream);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用druid数据库连接池获取连接
     */
    public static Connection getConnection() throws SQLException {
        Connection conn = dataSource.getConnection();
        return conn;
    }

    /**
     * 关闭数据库连接
     */
    public static void closeResource(Connection conn) {
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public static void closeResource(Connection conn, Statement ps, ResultSet rs) {
//        try {
//            if (conn != null)
//                conn.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            if (ps != null)
//                ps.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            if (rs != null)
//                rs.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }


}
