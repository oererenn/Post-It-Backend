package postit.demo.model;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CommunityModelTest {

    @Test
    void getId() {
        Long id = 1L;
        CommunityModel communityModel = new CommunityModel();
        communityModel.setId(id);
        Long userId = communityModel.getId();
        assertEquals(userId,id);
    }

    @Test
    void setId() {
        Long id = 1L;
        CommunityModel communityModel = new CommunityModel();
        communityModel.setId(id);
        Long userId = communityModel.getId();
        assertEquals(userId,id);
    }

    @Test
    void getName() {
        CommunityModel communityModel = new CommunityModel();
        communityModel.setName("Running");
        assertEquals("Running",communityModel.getName());
    }

    @Test
    void setName() {
        CommunityModel communityModel = new CommunityModel();
        communityModel.setName("Running");
        assertEquals("Running",communityModel.getName());
    }

    @Test
    void getDescription() {
        CommunityModel communityModel = new CommunityModel();
        communityModel.setDescription("Running");
        assertEquals("Running",communityModel.getDescription());
    }

    @Test
    void setDescription() {
        CommunityModel communityModel = new CommunityModel();
        communityModel.setDescription("Running");
        assertEquals("Running",communityModel.getDescription());
    }

    @Test
    void getCreatedAt() {
        CommunityModel communityModel = new CommunityModel();
        Instant instant = Instant.now();
        communityModel.setCreatedAt(instant);
        assertEquals(instant,communityModel.getCreatedAt());
    }

    @Test
    void setCreatedAt() {
        CommunityModel communityModel = new CommunityModel();
        Instant instant = Instant.now();
        communityModel.setCreatedAt(instant);
        assertEquals(instant,communityModel.getCreatedAt());
    }

    @Test
    void getTopic() {
        CommunityModel communityModel = new CommunityModel();
        TopicModel topicModel = mock(TopicModel.class);
        communityModel.setTopic(topicModel);
        assertEquals(topicModel,communityModel.getTopic());
    }

    @Test
    void setTopic() {
        CommunityModel communityModel = new CommunityModel();
        TopicModel topicModel = mock(TopicModel.class);
        communityModel.setTopic(topicModel);
        assertEquals(topicModel,communityModel.getTopic());
    }
}