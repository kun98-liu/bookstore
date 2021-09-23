package com.atguigu.test;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author LIU JIANKUN
 * @create 2021-09-05 21:09
 */
public class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void registUser() {
        userService.registUser(new User(null,"lichao","666666","lichao@gmail.com"));
    }

    @Test
    public void login() {
        User user = userService.login(new User(null, "jiankun", "ljk123", "liujiankun@gmail.com"));
        System.out.println(user);
    }

    @Test
    public void existsUsername() {
        boolean existsUsername = userService.existsUsername("jiankun");
        System.out.println(existsUsername);
    }
}