package postit.demo.service;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import postit.demo.model.UserModel;

import postit.demo.repository.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.UUID;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository mockUserRepository;

    @Test
    void getUsers() {
        userService.getUsers();
        verify(mockUserRepository,times(1)).findAll();
    }

    @Test
    void getUser() {
        UserModel userModel = new UserModel();
        userModel.setId(5L);
        userModel.setUsername("Onur");
        userService.getUser(userModel.getId());
        verify(mockUserRepository,times(1)).findById(userModel.getId());
    }

    @Test
    void updateUser() {
        UserModel userModel = mock(UserModel.class);
        userService.updateUser(userModel);
        verify(mockUserRepository).save(userModel);
    }

    @Test
    void addUser() {
        UserModel userModel = new UserModel();
        userModel.setId(5L);
        userModel.setUsername("Onur");

        Mockito.when(mockUserRepository.save(userModel)).thenReturn(userModel);


        assertThat(userService.addUser(userModel)).isEqualTo(userModel);

    }

    @Test
    void deleteUser() {
        UserModel userModel = mock(UserModel.class);
        userService.deleteUser(userModel.getId());
        verify(mockUserRepository).deleteById(userModel.getId());
    }

    @Test
    void addUserToCommunity() {
        UserModel userModel = mock(UserModel.class);
        userService.addUser(userModel);
        verify(mockUserRepository).save(userModel);
    }
}