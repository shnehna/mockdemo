package org.example.power.construction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author shenhan
 * @create 2020/1/15 10:56
 * @description
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService.class)
public class UserServiceTest {

    @Test
    public void save() throws Exception {
        final UserDao userDao = PowerMockito.mock(UserDao.class);
        String userName = "shenhan";
        String password = "shenhan123";
        PowerMockito.whenNew(UserDao.class).withArguments(userName, password).thenReturn(userDao);
        PowerMockito.doNothing().when(userDao).insert();
        UserService userService = new UserService();
        userService.save(userName, password);
        Mockito.verify(userDao, Mockito.times(1)).insert();
    }
}
