package postit.demo.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TopicDtoTest {

    @Test
    void getName() {
        TopicDto topicDto = new TopicDto();
        topicDto.setName("test");
        assertEquals(topicDto.getName(),"test");
    }

    @Test
    void setName() {
        TopicDto topicDto = new TopicDto();
        topicDto.setName("test");
        assertEquals(topicDto.getName(),"test");
    }
}