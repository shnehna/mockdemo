package org.example.power.spy;

/**
 * @author shenhan
 * @create 2020/1/15 14:26
 * @description
 */
public class UserService {
    public void foo(String arg) {
        log();
    }

    private void log() {
        System.out.println("I am console log.");
    }

    public boolean exist(String userName) {
        return checkExist(userName);
    }

    private boolean checkExist(String userName) {
        throw new UnsupportedOperationException();
    }
}
