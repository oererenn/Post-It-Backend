package postit.demo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleModelTest {

    @Test
    void getId() {
        Integer id = 1;
        RoleModel roleModel = new RoleModel();
        roleModel.setId(id);
        Integer userId = roleModel.getId();
        assertEquals(userId,id);
    }

    @Test
    void setId() {
        Integer id = 1;
        RoleModel roleModel = new RoleModel();
        roleModel.setId(id);
        Integer userId = roleModel.getId();
        assertEquals(userId,id);

    }

    @Test
    void getName() {
        RoleModel roleModel = new RoleModel();
        roleModel.setName(ERole.ROLE_ADMIN);
        assertEquals(ERole.ROLE_ADMIN,roleModel.getName());

    }

    @Test
    void setName() {
        RoleModel roleModel = new RoleModel();
        roleModel.setName(ERole.ROLE_ADMIN);
        assertEquals(ERole.ROLE_ADMIN,roleModel.getName());
    }
}