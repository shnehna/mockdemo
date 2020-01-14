package org.example.power.local.service;

import org.example.power.common.User;
import org.example.power.local.dao.UserDao;

/**
 * @author shenhan
 * @create 2020/1/14 16:43
 * @description
 */
public class UserService {

    public int queryUserCount() {
        UserDao userDao = new UserDao();
        return userDao.getCount();
    }

    public void saveUser(User user) {
        UserDao userDao = new UserDao();
        userDao.insertUser(user);
    }
}
