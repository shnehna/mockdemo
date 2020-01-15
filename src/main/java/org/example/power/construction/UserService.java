package org.example.power.construction;

/**
 * @author shenhan
 * @create 2020/1/15 10:53
 * @description
 */
public class UserService {
    public void save(String userName, String password) {
        UserDao userDao = new UserDao(userName,password);
        userDao.insert();
    }
}
