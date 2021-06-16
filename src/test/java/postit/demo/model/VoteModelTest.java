package postit.demo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class VoteModelTest {

    @Test
    void getId() {
        Long id = 1L;
        VoteModel voteModel = new VoteModel();
        voteModel.setId(id);
        Long userId = voteModel.getId();
        assertEquals(userId,id);
    }

    @Test
    void setId() {
        Long id = 1L;
        VoteModel voteModel = new VoteModel();
        voteModel.setId(id);
        Long userId = voteModel.getId();
        assertEquals(userId,id);
    }

    @Test
    void getVoteType() {
        VoteModel voteModel = new VoteModel();
        voteModel.setVoteType(VoteType.DOWN_VOTE);
        VoteType voteType = voteModel.getVoteType();
        assertEquals(VoteType.DOWN_VOTE,voteType);
    }

    @Test
    void setVoteType() {
        VoteModel voteModel = new VoteModel();
        voteModel.setVoteType(VoteType.UP_VOTE);
        VoteType voteType = voteModel.getVoteType();
        assertEquals(VoteType.UP_VOTE,voteType);
    }

    @Test
    void getPost() {
        VoteModel voteModel = new VoteModel();
        PostModel postModel = mock(PostModel.class);
        voteModel.setPost(postModel);
        PostModel post = voteModel.getPost();
        assertEquals(post,postModel);
    }

    @Test
    void setPost() {
        VoteModel voteModel = new VoteModel();
        PostModel postModel = mock(PostModel.class);
        voteModel.setPost(postModel);
        assertEquals(postModel,voteModel.getPost());
    }

    @Test
    void getUser() {
        VoteModel voteModel = new VoteModel();
        UserModel userModel = mock(UserModel.class);
        voteModel.setUser(userModel);
        UserModel user = voteModel.getUser();
        assertEquals(user,userModel);
    }

    @Test
    void setUser() {
        VoteModel voteModel = new VoteModel();
        UserModel userModel = mock(UserModel.class);
        voteModel.setUser(userModel);
        assertEquals(userModel,voteModel.getUser());
    }
}