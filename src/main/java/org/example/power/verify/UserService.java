package org.example.power.verify;

import org.example.power.common.User;


/**
 * @author shenhan
 * @create 2020/1/14 16:43
 * @description
 */
public class UserService {
    public void saveOrUpdate(User user) {
        UserDao userDao = new UserDao();
        if (userDao.getCount(user) > 0) {
            userDao.updateUser(user);
        } else {
            userDao.insertUser(user);
        }
    }
}
