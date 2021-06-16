package postit.demo.model;

import org.junit.jupiter.api.Test;

import javax.management.relation.Role;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserModelTest {

    @Test
    void testConstructor() {
        UserModel userModel = new UserModel("oereren","oereren@test.com","123456");
        assertEquals("oereren@test.com",userModel.getEmail());
        assertEquals("oereren",userModel.getUsername());
        assertEquals("123456",userModel.getPassword());


    }

    @Test
    void getId() {
        Long id = 1L;
        UserModel userModel = new UserModel();
        userModel.setId(id);
        Long userId = userModel.getId();
        assertEquals(userId,id);
    }

    @Test
    void setId() {
        Long id = 1L;
        UserModel userModel = new UserModel();
        userModel.setId(id);
        Long userId = userModel.getId();
        assertEquals(userId,id);
    }

    @Test
    void getUsername() {
        UserModel userModel = new UserModel();
        userModel.setUsername("Onur");
        String userName = userModel.getUsername();
        assertEquals("Onur",userName);
    }

    @Test
    void setUsername() {
        UserModel userModel = new UserModel();
        userModel.setUsername("Onur");
        String userName = userModel.getUsername();
        assertEquals("Onur",userName);
    }

    @Test
    void getPassword() {
        UserModel userModel = new UserModel();
        userModel.setPassword("123456789");
        String password = userModel.getPassword();
        assertEquals("123456789",password);
    }

    @Test
    void setPassword() {
        UserModel userModel = new UserModel();
        userModel.setPassword("123456789");
        assertEquals("123456789",userModel.getPassword());
    }

    @Test
    void getEmail() {
        UserModel userModel = new UserModel();
        userModel.setEmail("onurereren@hotmail.com");
        String email = userModel.getEmail();
        assertEquals("onurereren@hotmail.com",email);
    }

    @Test
    void setEmail() {
        UserModel userModel = new UserModel();
        userModel.setEmail("onurereren@hotmail.com");
        String email = userModel.getEmail();
        assertEquals("onurereren@hotmail.com",email);
    }

    @Test
    void getCreatedAt() {
        UserModel userModel = new UserModel();
        Instant instant = Instant.now();
        userModel.setCreatedAt(instant);
        assertEquals(instant,userModel.getCreatedAt());
    }

    @Test
    void setCreatedAt() {
        UserModel userModel = new UserModel();
        Instant instant = Instant.now();
        userModel.setCreatedAt(instant);
        assertEquals(instant,userModel.getCreatedAt());

    }

    @Test
    void getRoles() {
        UserModel userModel = new UserModel();
        RoleModel roleModel = new RoleModel();
        roleModel.setName(ERole.ROLE_ADMIN);
        Set<RoleModel> roles = new HashSet<>();
        roles.add(roleModel);
        userModel.setRoles(roles);
        assertEquals(roles,userModel.getRoles());
    }

    @Test
    void setRoles() {
        UserModel userModel = new UserModel();
        RoleModel roleModel = new RoleModel();
        roleModel.setName(ERole.ROLE_ADMIN);
        Set<RoleModel> roles = new HashSet<>();
        roles.add(roleModel);
        userModel.setRoles(roles);
        assertEquals(roles,userModel.getRoles());
    }
}