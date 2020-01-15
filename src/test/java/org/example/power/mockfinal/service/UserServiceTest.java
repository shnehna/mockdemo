package org.example.power.mockfinal.service;

import org.example.power.common.User;
import org.example.power.mockfinal.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author shenhan
 * @create 2020/1/15 10:02
 * @description
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class, UserDao.class})
public class UserServiceTest {
    /*@Mock
    private UserDao userDao;*/

    /*@Ignore
    @Test
    public void queryUserCountWithMockito() {
        MockitoAnnotations.initMocks(this);
        UserService userService = new UserService(userDao);
        Mockito.when(userDao.getCount()).thenReturn(10);
        int result = userService.queryUserCount();
        assertEquals(10, result);
    }*/

    @Test
    public void queryUserCountWithPowerMock() {
        final UserDao uDao = PowerMockito.mock(UserDao.class);
        System.out.println(uDao.getClass());
        PowerMockito.when(uDao.getCount()).thenReturn(10);
        UserService userService = new UserService(uDao);
        int result = userService.queryUserCount();
        assertEquals(10, result);
    }

    @Test
    public void saveUser() {
        try {
            final UserDao dao = PowerMockito.mock(UserDao.class);
            System.out.println(dao.getClass());
            PowerMockito.whenNew(UserDao.class).withNoArguments().thenReturn(dao);
            User user = new User();
            PowerMockito.doNothing().when(dao).insertUser(user);
            UserService service = new UserService(dao);
            service.saveUser(user);
        } catch (Exception e) {
            fail();
        }
    }
}
