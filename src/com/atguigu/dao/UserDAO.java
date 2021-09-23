package com.atguigu.dao;

import com.atguigu.pojo.User;

/**
 * @author LIU JIANKUN
 * @create 2021-09-03 23:37
 */
public interface UserDAO {
    /**
     * 通过用户名查找User数据
     * @param username
     * @return 返回null表示没找到
     */
    User queryUserByUsername(String username);

    /**
     * 通过用户名和密码查找User数据
     * @param username
     * @param password
     * @return 返回null表示没找到
     */
    User queryUserByUsernameAndPassword(String username, String password);

    /**
     * 将user保存至表中
     * @param user
     * @return 返回-1表示添加失败
     */
    int saveUser(User user);


}
