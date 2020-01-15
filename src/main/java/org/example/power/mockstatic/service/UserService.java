package org.example.power.mockstatic.service;

import org.example.power.common.User;
import org.example.power.mockstatic.dao.UserDao;


/**
 * @author shenhan
 * @create 2020/1/14 16:43
 * @description
 */
public class UserService {
    public int queryUserCount() {
        return UserDao.getCount();
    }

    public void saveUser(User user) {
        UserDao.insertUser(user);
    }
}
