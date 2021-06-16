package postit.demo.controller;



import org.junit.After;
import org.junit.AfterClass;
import org.junit.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.event.annotation.AfterTestClass;
import org.springframework.test.context.event.annotation.AfterTestMethod;
import org.springframework.test.context.junit4.SpringRunner;
import postit.demo.model.CommentModel;
import postit.demo.repository.CommentRepository;
import postit.demo.repository.PostRepository;
import postit.demo.repository.UserRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CommentControllerTest {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @LocalServerPort
    private int port;

    @AfterEach
    public void tearDown() throws Exception {
        commentRepository.deleteAll();
        postRepository.deleteAll();
        userRepository.deleteAll();
    }


    @Test
    void getComments() {
        when()
                .get(String.format("http://localhost:%s/api/comments", port))
                .then()
                .statusCode(is(200));
    }

    @Test
    void getComment() {
        CommentModel commentModel = new CommentModel();
        commentModel.setId(5L);
        commentRepository.save(commentModel);
        when()
                .get(String.format("http://localhost:%s/api/comments/{id}", port),commentModel.getId())
                .then()
                .statusCode(is(200));

    }
}