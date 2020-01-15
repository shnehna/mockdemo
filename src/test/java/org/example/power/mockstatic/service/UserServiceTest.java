package org.example.power.mockstatic.service;

import org.example.power.common.User;
import org.example.power.mockstatic.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static com.sun.javaws.JnlpxArgs.verify;
import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.*;

/**
 * @author shenhan
 * @create 2020/1/15 9:24
 * @description
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class, UserDao.class})
public class UserServiceTest {

    @Test
    public void queryUserCount() {
        mockStatic(UserDao.class);
        when(UserDao.getCount()).thenReturn(10);
        UserService service = new UserService();
        int result = service.queryUserCount();
        assertEquals(10, result);
    }

    @Test
    public void saveUser() {
        mockStatic(UserDao.class);
        User user = new User();
        doNothing().when(UserDao.class);
        UserService service = new UserService();
        service.saveUser(user);
    }
}
