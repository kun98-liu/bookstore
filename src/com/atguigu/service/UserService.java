package com.atguigu.service;

import com.atguigu.pojo.User;

/**
 * @author LIU JIANKUN
 * @create 2021-09-05 21:01
 */
public interface UserService {

    /**
     * 用户注册
     * @param user
     */
    void registUser(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 验证是否存在用户
     * @param username
     * @return
     */
    boolean existsUsername(String username);

}
