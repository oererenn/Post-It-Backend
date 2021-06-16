package postit.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import postit.demo.converter.VoteConverter;
import postit.demo.dto.VoteDto;
import postit.demo.model.VoteModel;
import postit.demo.service.VoteService;

import java.util.List;
import java.util.Optional;

@RestController
public class VoteController {

    private final VoteService voteService;

    private final VoteConverter voteConverter;

    @Autowired
    public VoteController(VoteService voteService, VoteConverter voteConverter) {
        this.voteService = voteService;
        this.voteConverter = voteConverter;
    }


    @GetMapping(value = "/api/votes")
    public List<VoteModel> getVotes(){

        return voteService.getVotes();
    }

    @GetMapping(value = "/api/votes/{id}")
    public Optional<VoteModel> getVote(@PathVariable Long id){
        return voteService.getVote(id);
    }

    @PostMapping(value = "/api/votes")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public void addTopic(@RequestBody VoteDto voteDto){
        voteConverter.dtoToEntity(voteDto);
    }

    @DeleteMapping( value = "/api/votes/{id}")
    public void deleteVote(@PathVariable Long id){
        voteService.deleteVote(id);
    }
}
