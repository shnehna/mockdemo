package org.example.power.verify;

import org.example.power.common.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

/**
 * @author shenhan
 * @create 2020/1/15 10:31
 * @description
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class})
public class UserServiceTest {

    @Test
    public void saveOrUpdateWillUserNewJoiner() throws Exception{
        final User user = PowerMockito.mock(User.class);
        final UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);
        PowerMockito.when(userDao.getCount(user)).thenReturn(0);
        UserService userService = new UserService();
        userService.saveOrUpdate(user);
        Mockito.verify(userDao).insertUser(user);
        Mockito.verify(userDao,Mockito.never()).updateUser(user);
    }

    @Test
    public void saveOrUpdateWillUserUpdateJoiner() throws Exception{
        final User user = PowerMockito.mock(User.class);
        final UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);
        PowerMockito.when(userDao.getCount(user)).thenReturn(2);
        UserService userService = new UserService();
        userService.saveOrUpdate(user);
        Mockito.verify(userDao,Mockito.never()).insertUser(user);
        Mockito.verify(userDao,Mockito.times(1)).updateUser(user);
    }
}
