package org.example.power.mockfinal.service;

import org.example.power.common.User;
import org.example.power.mockfinal.dao.UserDao;

/**
 * @author shenhan
 * @create 2020/1/14 16:43
 * @description
 */
public class UserService {
    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public int queryUserCount() {
        return userDao.getCount();
    }

    public void saveUser(User user) {
        userDao.insertUser(user);
    }
}
