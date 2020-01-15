package org.example.power.construction;

/**
 * @author shenhan
 * @create 2020/1/15 10:54
 * @description
 */
public class UserDao {
    private String userName;
    private String password;

    public UserDao(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public void insert() {
        throw new UnsupportedOperationException();
    }
}
