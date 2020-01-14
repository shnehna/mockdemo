package org.example.power.helloworld.service;

import org.example.power.common.User;
import org.example.power.helloworld.dao.UserDao;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;

import static org.junit.Assert.*;

/**
 * @author shenhan
 * @create 2020/1/14 16:48
 * @description
 */
public class UserServiceTest {

    private UserService userService;

    @Before
    public void setup() {
        userService = new UserService(new UserDao());
    }

    @Mock
    private UserDao userDao;

    @Test
    public void testQueryUserCountWithPowerMock() {
        UserDao dao = PowerMockito.mock(UserDao.class);
        PowerMockito.doReturn(10).when(dao).getCount();
//        PowerMockito.when(dao.getCount()).thenReturn(10);
        UserService service = new UserService(dao);
        final int count = service.queryUserCount();
        assertEquals(10, count);
    }

    @Test
    public void testSaveUserCountWithPowerMock() {
        UserDao dao = PowerMockito.mock(UserDao.class);
        User user = new User();
        PowerMockito.doNothing().when(dao).insertUser(user);
        UserService service = new UserService(dao);
        service.saveUser(user);
        Mockito.verify(dao).insertUser(user);
    }


    @Ignore
    @Test
    public void testQueryUserCountWithMocktio() {
        MockitoAnnotations.initMocks(this);
        UserService service = new UserService(userDao);
        Mockito.when(userDao.getCount()).thenReturn(10);

        int result = service.queryUserCount();
        assertEquals(10, result);
    }

    @Ignore
    @Test
    public void queryUserCountWhitJunit() {
        try {
            userService.queryUserCount();
            fail("should not process to here");
        } catch (Exception e) {
            assertTrue(e instanceof UnsupportedOperationException);
        }
    }

    @Ignore
    @Test
    public void saveUserWhitJunit() {
        try {
            userService.saveUser(new User());
            fail("should not process to here");
        } catch (Exception e) {
            assertTrue(e instanceof UnsupportedOperationException);
        }
    }
}
