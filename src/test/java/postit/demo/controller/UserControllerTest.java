package postit.demo.controller;


import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import postit.demo.model.UserModel;
import postit.demo.repository.UserRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {
    @Autowired
    private UserRepository userRepository;

    @LocalServerPort
    private int port;

    @AfterEach
    public void tearDown() throws Exception {
        userRepository.deleteAll();
    }

    @Test
    void getUsers() {
        when()
                .get(String.format("http://localhost:%s/api/users", port))
                .then()
                .statusCode(is(200));
    }

    @Test
    void getUser() {
        UserModel userModel = new UserModel();
        userModel.setId(5L);
        userRepository.save(userModel);
        when()
                .get(String.format("http://localhost:%s/api/users/{id}", port),userModel.getId())
                .then()
                .statusCode(is(200));
    }

    @Test
    void addUser() {
        UserModel userModel = new UserModel();
        userModel.setId(5L);
        userModel.setUsername("test");

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("id", userModel.getId());
        jsonAsMap.put("name", userModel.getUsername());
        userRepository.save(userModel);
        given().contentType(JSON).
                body(jsonAsMap)
                .when()
                .post(String.format("http://localhost:%s/api/users", port))
                .then()
                .statusCode(200);
    }

}