package postit.demo.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommunityDtoTest {

    @Test
    void getName() {
        CommunityDto communityDto = new CommunityDto();
        communityDto.setName("test");
        assertEquals(communityDto.getName(),"test");
    }

    @Test
    void setName() {
        CommunityDto communityDto = new CommunityDto();
        communityDto.setName("test");
        assertEquals(communityDto.getName(),"test");
    }

    @Test
    void getDescription() {
        CommunityDto communityDto = new CommunityDto();
        communityDto.setDescription("test");
        assertEquals(communityDto.getDescription(),"test");
    }

    @Test
    void setDescription() {
        CommunityDto communityDto = new CommunityDto();
        communityDto.setDescription("test");
        assertEquals(communityDto.getDescription(),"test");
    }

    @Test
    void getTopicId() {
        CommunityDto communityDto = new CommunityDto();
        communityDto.setTopicId(5L);
        assertEquals(communityDto.getTopicId(),5L);
    }

    @Test
    void setTopicId() {
        CommunityDto communityDto = new CommunityDto();
        communityDto.setTopicId(5L);
        assertEquals(communityDto.getTopicId(),5L);
    }
}