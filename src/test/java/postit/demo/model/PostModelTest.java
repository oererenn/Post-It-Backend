package postit.demo.model;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class PostModelTest {

    @Test
    void getId() {
        Long id = 1L;
        PostModel postModel = new PostModel();
        postModel.setId(id);
        Long userId = postModel.getId();
        assertEquals(userId,id);
    }

    @Test
    void setId() {
        Long id = 1L;
        PostModel postModel = new PostModel();
        postModel.setId(id);
        Long userId = postModel.getId();
        assertEquals(userId,id);

    }

    @Test
    void getTitle() {
        PostModel postModel = new PostModel();
        postModel.setTitle("test");
        assertEquals("test",postModel.getTitle());
    }

    @Test
    void setTitle() {
        PostModel postModel = new PostModel();
        postModel.setTitle("test");
        assertEquals("test",postModel.getTitle());
    }

    @Test
    void getDescription() {
        PostModel postModel = new PostModel();
        postModel.setDescription("testDescription");
        assertEquals("testDescription",postModel.getDescription());
    }

    @Test
    void setDescription() {
        PostModel postModel = new PostModel();
        postModel.setDescription("testDescription");
        assertEquals("testDescription",postModel.getDescription());
    }

    @Test
    void getCreatedAt() {
        PostModel postModel = new PostModel();
        Instant instant = Instant.now();
        postModel.setCreatedAt(instant);
        assertEquals(instant,postModel.getCreatedAt());
    }

    @Test
    void setCreatedAt() {
        PostModel postModel = new PostModel();
        Instant instant = Instant.now();
        postModel.setCreatedAt(instant);
        assertEquals(instant,postModel.getCreatedAt());
    }

    @Test
    void getImage() {
        PostModel postModel = new PostModel();
        postModel.setImage("path");
        String imagePath = postModel.getImage().orElseThrow();
        assertEquals("path",imagePath);
    }

    @Test
    void setImage() {
        PostModel postModel = new PostModel();
        postModel.setImage("path");
        String imagePath = postModel.getImage().orElseThrow();
        assertEquals("path",imagePath);
    }

    @Test
    void getVoteCount() {
        PostModel postModel = new PostModel();
        postModel.setVoteCount(12);
        assertEquals(12,postModel.getVoteCount());
    }

    @Test
    void setVoteCount() {
        PostModel postModel = new PostModel();
        postModel.setVoteCount(12);
        assertEquals(12,postModel.getVoteCount());
    }

    @Test
    void getUser() {
        PostModel postModel = new PostModel();
        UserModel usermodel = mock(UserModel.class);
        postModel.setUser(usermodel);
        UserModel user = postModel.getUser();
        assertEquals(user,usermodel);
    }

    @Test
    void setUser() {
        PostModel postModel = new PostModel();
        UserModel usermodel = mock(UserModel.class);
        postModel.setUser(usermodel);
        assertEquals(usermodel,postModel.getUser());
    }

    @Test
    void getCommunity() {
        PostModel postModel = new PostModel();
        CommunityModel communityModel = mock(CommunityModel.class);
        postModel.setCommunity(communityModel);
        assertEquals(communityModel,postModel.getCommunity());
    }

    @Test
    void setCommunity() {
        PostModel postModel = new PostModel();
        CommunityModel communityModel = mock(CommunityModel.class);
        postModel.setCommunity(communityModel);
        assertEquals(communityModel,postModel.getCommunity());
    }
}