package postit.demo.dto;

import org.junit.jupiter.api.Test;
import postit.demo.model.VoteType;

import static org.junit.jupiter.api.Assertions.*;

class VoteDtoTest {

    @Test
    void getPostId() {
        VoteDto voteDto = new VoteDto();
        voteDto.setPostId(5L);
        assertEquals(voteDto.getPostId(),5L);
    }

    @Test
    void setPostId() {
        VoteDto voteDto = new VoteDto();
        voteDto.setPostId(5L);
        assertEquals(voteDto.getPostId(),5L);
    }

    @Test
    void getUserId() {
        VoteDto voteDto = new VoteDto();
        voteDto.setUserId(5L);
        assertEquals(voteDto.getUserId(),5L);
    }

    @Test
    void setUserId() {
        VoteDto voteDto = new VoteDto();
        voteDto.setUserId(5L);
        assertEquals(voteDto.getUserId(),5L);
    }

    @Test
    void getVoteType() {
        VoteDto voteDto = new VoteDto();
        voteDto.setVoteType(VoteType.UP_VOTE);
        assertEquals(voteDto.getVoteType(),VoteType.UP_VOTE);
    }

    @Test
    void setVoteType() {
        VoteDto voteDto = new VoteDto();
        voteDto.setVoteType(VoteType.UP_VOTE);
        assertEquals(voteDto.getVoteType(),VoteType.UP_VOTE);
    }
}