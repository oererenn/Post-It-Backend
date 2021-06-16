package postit.demo.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDtoTest {

    @Test
    void getDtoId() {
        UserDto userDto = new UserDto();
        userDto.setDtoId(5L);
        assertEquals(userDto.getDtoId(),5L);
    }

    @Test
    void setDtoId() {
        UserDto userDto = new UserDto();
        userDto.setDtoId(5L);
        assertEquals(userDto.getDtoId(),5L);
    }

    @Test
    void getDtoUsername() {
        UserDto userDto = new UserDto();
        userDto.setDtoUsername("test");
        assertEquals(userDto.getDtoUsername(),"test");
    }

    @Test
    void setDtoUsername() {
        UserDto userDto = new UserDto();
        userDto.setDtoUsername("test");
        assertEquals(userDto.getDtoUsername(),"test");
    }

    @Test
    void getDtoPassword() {
        UserDto userDto = new UserDto();
        userDto.setDtoPassword("test");
        assertEquals(userDto.getDtoPassword(),"test");
    }

    @Test
    void setDtoPassword() {
        UserDto userDto = new UserDto();
        userDto.setDtoPassword("test");
        assertEquals(userDto.getDtoPassword(),"test");
    }

    @Test
    void getDtoEmail() {
        UserDto userDto = new UserDto();
        userDto.setDtoEmail("test");
        assertEquals(userDto.getDtoEmail(),"test");
    }

    @Test
    void setDtoEmail() {
        UserDto userDto = new UserDto();
        userDto.setDtoEmail("test");
        assertEquals(userDto.getDtoEmail(),"test");
    }
}