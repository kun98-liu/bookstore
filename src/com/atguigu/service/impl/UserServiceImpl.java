package com.atguigu.service.impl;

import com.atguigu.dao.UserDAO;
import com.atguigu.dao.impl.UserDAOImpl;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;

/**
 * @author LIU JIANKUN
 * @create 2021-09-05 21:05
 */
public class UserServiceImpl implements UserService {

    private UserDAO userDAO = new UserDAOImpl();


    @Override
    public void registUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDAO.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if(userDAO.queryUserByUsername(username) != null){
            return true;
        }

        return false;
    }
}
