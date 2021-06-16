package postit.demo.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.core.Is.is;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import postit.demo.model.TopicModel;
import postit.demo.repository.TopicRepository;

import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TopicControllerTest {
    @Autowired
    private TopicRepository topicRepository;

    @LocalServerPort
    private int port;

    @AfterEach
    public void tearDown() throws Exception {
        topicRepository.deleteAll();
    }


    @Test
    void getTopics() {

        when()
                .get(String.format("http://localhost:%s/api/topics", port))
                .then()
                .statusCode(is(200));

    }

    @Test
    void getTopic() {
        TopicModel topicModel = new TopicModel();
        topicModel.setId(5L);
        topicRepository.save(topicModel);
        when()
                .get(String.format("http://localhost:%s/api/topics/{id}", port),topicModel.getId())
                .then()
                .statusCode(is(200));

    }

    @Test
    void addTopic() {
        TopicModel topicModel = new TopicModel();
        topicModel.setId(5L);
        topicModel.setName("test");

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("id", topicModel.getId());
        jsonAsMap.put("name", topicModel.getName());
        topicRepository.save(topicModel);
        given().contentType(JSON).
                body(jsonAsMap)
                .when()
                .post(String.format("http://localhost:%s/api/topics", port))
                .then()
                .statusCode(401);
    }
}