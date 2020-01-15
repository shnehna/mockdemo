package org.example.power.matcher;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;

/**
 * @author shenhan
 * @create 2020/1/15 11:04
 * @description
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService.class)
public class UserServiceTest {

    @Test
    public void find() throws Exception {
        final UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);
        PowerMockito.when(userDao.queryByName("shenhan")).thenReturn("liushaung");
        UserService service = new UserService();
        final String result = service.find("shenhan");
        assertEquals("liushaung", result);
    }

    @Test
    public void findWithMatcher() throws Exception {
        final UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);
        PowerMockito.when(userDao.queryByName(Mockito.argThat(new MyArgumentMatcher()))).thenReturn("沈涵");
        UserService service = new UserService();
        assertEquals("沈涵",service.find("Alex"));
        assertEquals("沈涵",service.find("shenhan"));
        assertEquals("沈涵",service.find("liushuang"));
        assertEquals("沈涵",service.find("Tony"));

    }

    static class MyArgumentMatcher implements ArgumentMatcher<String> {

        @Override
        public boolean matches(String argument) {
            switch (argument) {
                case "Alex":
                case "shenhan":
                case "liushuang":
                case "Tony":
                    return true;
                default:
                    return false;
            }
        }
    }
}
