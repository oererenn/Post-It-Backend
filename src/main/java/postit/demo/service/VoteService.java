package postit.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import postit.demo.model.VoteModel;
import postit.demo.repository.VoteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VoteService {

    private VoteRepository voteRepository;

    @Autowired
    public VoteService(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }


    public List<VoteModel> getVotes()
    {
        List<VoteModel> votes = new ArrayList<>();
        voteRepository.findAll().forEach(votes::add);
        return votes;
    }

    public Optional<VoteModel> getVote(Long id){

        return voteRepository.findById(id);
    }

    public void updateVote(VoteModel vote){
        voteRepository.save(vote);
    }

    public void addVote(VoteModel vote){
        voteRepository.save(vote);
    }


    public void deleteVote(Long id){
        voteRepository.deleteById(id);
    }
}
