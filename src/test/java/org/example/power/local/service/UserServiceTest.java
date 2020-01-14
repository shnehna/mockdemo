package org.example.power.local.service;

import org.example.power.common.User;
import org.example.power.local.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.*;

/**
 * @author shenhan
 * @create 2020/1/14 17:54
 * @description
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService.class)
public class UserServiceTest {

    @Test
    public void queryUserCount() {
        try {
            UserService userService = new UserService();
            final UserDao mock = mock(UserDao.class);
            whenNew(UserDao.class).withNoArguments().thenReturn(mock);
            doReturn(10).when(mock).getCount();
            final int count = userService.queryUserCount();
            assertEquals(10,count);
        } catch (Throwable throwable) {
            fail();
        }
    }

    @Test
    public void saveUser() {
        try {
            UserService userService = new UserService();
            final UserDao mock = mock(UserDao.class);
            whenNew(UserDao.class).withAnyArguments().thenReturn(mock);
            User user = new User();
            doNothing().when(mock).insertUser(user);
            userService.saveUser(user);
            Mockito.verify(mock,Mockito.times(1)).insertUser(user);
        } catch (Exception e) {
            fail();
        }
    }
}
