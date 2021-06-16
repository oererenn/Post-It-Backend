package postit.demo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TopicModelTest {

    @Test
    void getId() {
        Long id = 1L;
        TopicModel topicModel = new TopicModel();
        topicModel.setId(id);
        Long userId = topicModel.getId();
        assertEquals(userId,id);
    }

    @Test
    void setId() {
        Long id = 1L;
        TopicModel topicModel = new TopicModel();
        topicModel.setId(id);
        Long userId = topicModel.getId();
        assertEquals(userId,id);
    }

    @Test
    void getName() {
        TopicModel topicModel = new TopicModel();
        topicModel.setName("Sports");
        assertEquals("Sports",topicModel.getName());
    }

    @Test
    void setName() {
        TopicModel topicModel = new TopicModel();
        topicModel.setName("Sports");
        assertEquals("Sports",topicModel.getName());
    }
}