package postit.demo.service;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import postit.demo.model.VoteModel;
import postit.demo.repository.VoteRepository;
import static org.mockito.Mockito.*;



@RunWith(SpringRunner.class)
@SpringBootTest
class VoteServiceTest {

    @Autowired
    private VoteService voteService;

    @MockBean
    private VoteRepository mockVoteRepository;


    @Test
    void getVotes() {
        voteService.getVotes();
        verify(mockVoteRepository,times(1)).findAll();
    }

    @Test
    void getVote() {
        VoteModel voteModel = new VoteModel();
        voteModel.setId(5L);

        voteService.getVote(voteModel.getId());
        verify(mockVoteRepository,times(1)).findById(voteModel.getId());
    }

    @Test
    void updateVote() {
        VoteModel voteModel = mock(VoteModel.class);
        voteService.updateVote(voteModel);
        verify(mockVoteRepository).save(voteModel);
    }

    @Test
    void addVote() {
        VoteModel voteModel = mock(VoteModel.class);
        voteService.addVote(voteModel);
        verify(mockVoteRepository).save(voteModel);

    }

    @Test
    void deleteVote() {
        VoteModel voteModel = mock(VoteModel.class);
        voteService.deleteVote(voteModel.getId());
        verify(mockVoteRepository).deleteById(voteModel.getId());
    }

}