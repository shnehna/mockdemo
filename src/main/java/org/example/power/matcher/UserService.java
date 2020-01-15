package org.example.power.matcher;

/**
 * @author shenhan
 * @create 2020/1/15 10:53
 * @description
 */
public class UserService {
    public String find(String name) {
        UserDao userDao = new UserDao();
        return userDao.queryByName(name);
    }
}
