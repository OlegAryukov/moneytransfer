package transfer;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Test;
import ru.aryukov.revolut.dto.UserDto;
import ru.aryukov.revolut.dto.post.UserPost;
import ru.aryukov.revolut.modules.BaseModule;
import ru.aryukov.revolut.service.UserService;
import ru.aryukov.revolut.service.impl.UserServiceImpl;
import ru.aryukov.revolut.web.UserController;

import javax.validation.ValidationException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class UserServiceTest {

    Injector injector = Guice.createInjector(new BaseModule());
    UserService userService = injector.getInstance(UserServiceImpl.class);
    UserController userController = injector.getInstance(UserController.class);

    @Test
    public void createUserTest() {
        UserDto user = (UserDto) userService.createUser(TestDataUtils.getUserPost());
        assertThat(user.getName(), is(TestDataUtils.getUserPost().getName()));
        assertThat(user.getSecondName(), is(TestDataUtils.getUserPost().getSecondName()));
    }

    @Test
    public void createAndGetUserTest() {
        userService.createUser(TestDataUtils.getUserPost());
        UserDto getUser = (UserDto) userService.getUserById(4L);
        assertThat(getUser.getId(), is(4L));
        assertThat(getUser.getName(), is(TestDataUtils.getUserPost().getName()));
        assertThat(getUser.getSecondName(), is(TestDataUtils.getUserPost().getSecondName()));
    }

    @Test(expected = ValidationException.class)
    public void negativeCreateUser(){
        UserPost user = TestDataUtils.getUserPost();
        user.setName(null);
        userController.validateIncome(user);
    }

}
