package postit.demo.dto;

import org.junit.jupiter.api.Test;
import postit.demo.model.VoteType;

import static org.junit.jupiter.api.Assertions.*;

class UserCommunityDtoTest {

    @Test
    void getCommunityId() {
        UserCommunityDto userCommunityDto = new UserCommunityDto();
        userCommunityDto.setCommunityId(5L);
        assertEquals(userCommunityDto.getCommunityId(),5L);
    }

    @Test
    void setCommunityId() {
        UserCommunityDto userCommunityDto = new UserCommunityDto();
        userCommunityDto.setCommunityId(5L);
        assertEquals(userCommunityDto.getCommunityId(),5L);
    }

    @Test
    void getUserId() {
        UserCommunityDto userCommunityDto = new UserCommunityDto();
        userCommunityDto.setUserId(5L);
        assertEquals(userCommunityDto.getUserId(),5L);
    }

    @Test
    void setUserId() {
        UserCommunityDto userCommunityDto = new UserCommunityDto();
        userCommunityDto.setUserId(5L);
        assertEquals(userCommunityDto.getUserId(),5L);
    }
}