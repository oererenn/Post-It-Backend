package postit.demo.model;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CommentModelTest {

    @Test
    void getId() {
        Long id = 1L;
        CommentModel commentModel = new CommentModel();
        commentModel.setId(id);
        Long userId = commentModel.getId();
        assertEquals(userId,id);
    }

    @Test
    void setId() {
        Long id = 1L;
        CommentModel commentModel = new CommentModel();
        commentModel.setId(id);
        Long userId = commentModel.getId();
        assertEquals(userId,id);
    }

    @Test
    void getText() {
        CommentModel commentModel = new CommentModel();
        commentModel.setText("Text");
        assertEquals("Text",commentModel.getText());
    }

    @Test
    void setText() {
        CommentModel commentModel = new CommentModel();
        commentModel.setText("Text");
        assertEquals("Text",commentModel.getText());
    }

    @Test
    void getCreatedAt() {
        CommentModel commentModel = new CommentModel();
        Instant instant = Instant.now();
        commentModel.setCreatedAt(instant);
        assertEquals(instant,commentModel.getCreatedAt());
    }

    @Test
    void setCreatedAt() {
        CommentModel commentModel = new CommentModel();
        Instant instant = Instant.now();
        commentModel.setCreatedAt(instant);
        assertEquals(instant,commentModel.getCreatedAt());
    }

    @Test
    void getPost() {
        CommentModel commentModel = new CommentModel();
        PostModel postModel = mock(PostModel.class);
        commentModel.setPost(postModel);
        assertEquals(postModel,commentModel.getPost());
    }

    @Test
    void setPost() {
        CommentModel commentModel = new CommentModel();
        PostModel postModel = mock(PostModel.class);
        commentModel.setPost(postModel);
        assertEquals(postModel,commentModel.getPost());
    }

    @Test
    void getUser() {
        CommentModel commentModel = new CommentModel();
        UserModel userModel = mock(UserModel.class);
        commentModel.setUser(userModel);
        assertEquals(userModel,commentModel.getUser());
    }

    @Test
    void setUser() {
        CommentModel commentModel = new CommentModel();
        UserModel userModel = mock(UserModel.class);
        commentModel.setUser(userModel);
        assertEquals(userModel,commentModel.getUser());
    }
}