package org.example.power.spy;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertTrue;

/**
 * @author shenhan
 * @create 2020/1/15 14:27
 * @description
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService.class)
public class UserServiceTest {

    @Test
    public void fooWithSpy() {
        final UserService userService = PowerMockito.spy(new UserService());
        String arg = "Hello";
        PowerMockito.doNothing().when(userService).foo(arg);
        userService.foo(arg);
//        userService.foo("arg");
    }

    @Test
    public void testCheck() throws Exception {
        final UserService userService = PowerMockito.spy(new UserService());
        // 测试私有方法
        PowerMockito.doReturn(true).when(userService, "checkExist", "alex");
        assertTrue(userService.exist("alex"));
//        userService.exist("other");
    }

    @Ignore
    @Test
    public void foo() {
        final UserService userService = PowerMockito.mock(UserService.class);
//        userService.foo();
    }
}
