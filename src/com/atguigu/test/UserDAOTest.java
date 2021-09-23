package com.atguigu.test;

import com.atguigu.dao.UserDAO;
import com.atguigu.dao.impl.UserDAOImpl;
import com.atguigu.pojo.User;
import org.junit.Test;


/**
 * @author LIU JIANKUN
 * @create 2021-09-04 0:04
 */
public class UserDAOTest {
    UserDAO userDAO = new UserDAOImpl();
    @Test
    public void queryUserByUsername() {

        User admin = userDAO.queryUserByUsername("admin");
        System.out.println(admin);
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        User admin = userDAO.queryUserByUsernameAndPassword("admin", "123456");
        System.out.println(admin);
    }

    @Test
    public void saveUser() {
        int saveUser = userDAO.saveUser(new User(null, "jiankun", "ljk123", "liujiankun@gmail.com"));
        System.out.println(saveUser);
    }
}