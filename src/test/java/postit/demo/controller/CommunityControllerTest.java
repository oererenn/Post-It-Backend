package postit.demo.controller;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import postit.demo.model.CommunityModel;
import postit.demo.model.TopicModel;
import postit.demo.repository.CommunityRepository;
import postit.demo.repository.TopicRepository;

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
class CommunityControllerTest {
    @Autowired
    private CommunityRepository communityRepository;
    @Autowired
    private TopicRepository topicRepository;

    @LocalServerPort
    private int port;

    @AfterEach
    public void tearDown() throws Exception {
        communityRepository.deleteAll();
    }

    @Test
    void getCommunities() {
        when()
                .get(String.format("http://localhost:%s/api/communities", port))
                .then()
                .statusCode(is(200));
    }

    @Test
    void getCommunity() {
        CommunityModel communityModel = new CommunityModel();
        communityModel.setId(5L);
        communityRepository.save(communityModel);
        when()
                .get(String.format("http://localhost:%s/api/communities/{id}", port),communityModel.getId())
                .then()
                .statusCode(is(200));
    }

}