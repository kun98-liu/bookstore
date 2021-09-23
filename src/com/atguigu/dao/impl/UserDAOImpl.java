package com.atguigu.dao.impl;

import com.atguigu.dao.BaseDAO;
import com.atguigu.dao.UserDAO;
import com.atguigu.pojo.User;

/**
 * @author LIU JIANKUN
 * @create 2021-09-03 23:49
 */
public class UserDAOImpl extends BaseDAO implements UserDAO {

    @Override
    public User queryUserByUsername(String username) {
        String sql = "select id, username, password, email from t_user where username = ?";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select `id` id, `username`, `password`, `email` from t_user where username = ? and password = ?";
        return queryForOne(User.class, sql, username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(username,password,email) values(?,?,?)";
        int update = update(sql, user.getUsername(), user.getPassword(), user.getEmail());
        return update;
    }
}
