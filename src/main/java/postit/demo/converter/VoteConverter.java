package postit.demo.converter;

import org.springframework.stereotype.Component;
import postit.demo.dto.VoteDto;
import postit.demo.model.PostModel;
import postit.demo.model.UserModel;
import postit.demo.model.VoteModel;
import postit.demo.model.VoteType;
import postit.demo.repository.PostRepository;
import postit.demo.repository.UserRepository;
import postit.demo.repository.VoteRepository;

import java.util.List;
@Component
public class VoteConverter {

    private VoteRepository voteRepository;
    private PostRepository postRepository;
    private UserRepository userRepository;

    public VoteConverter(VoteRepository voteRepository, PostRepository postRepository, UserRepository userRepository) {
        this.voteRepository = voteRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }


    public void dtoToEntity(VoteDto dto){
        UserModel userModel = userRepository.findById(dto.getUserId()).orElseThrow();
        PostModel postModel = postRepository.findById(dto.getPostId()).orElseThrow();
        boolean voteExist = false;
        VoteModel voteModel=new VoteModel();
        List<VoteModel> userVotes = voteRepository.findByUserId(userModel.getId());



        for (int i = 0; i < userVotes.size(); i++) {
            if(userVotes.get(i).getUser().getId().equals(dto.getUserId()) && userVotes.get(i).getPost().getId().equals(dto.getPostId())){
                if(userVotes.get(i).getVoteType()==VoteType.UP_VOTE){
                    if(dto.getVoteType()==VoteType.UP_VOTE){
                        postModel.setVoteCount(postModel.getVoteCount()-1);
                        voteRepository.deleteById(userVotes.get(i).getId());
                    }else if(dto.getVoteType()==VoteType.DOWN_VOTE){
                        postModel.setVoteCount(postModel.getVoteCount()-2);
                        userVotes.get(i).setVoteType(dto.getVoteType());
                        voteRepository.save(userVotes.get(i));
                    }
                }else if(userVotes.get(i).getVoteType()==VoteType.DOWN_VOTE) {
                    if (dto.getVoteType() == VoteType.DOWN_VOTE) {
                        postModel.setVoteCount(postModel.getVoteCount() + 1);
                        voteRepository.deleteById(userVotes.get(i).getId());
                    }
                    else if(dto.getVoteType() == VoteType.UP_VOTE) {
                        postModel.setVoteCount(postModel.getVoteCount() + 2);
                        userVotes.get(i).setVoteType(dto.getVoteType());
                        voteRepository.save(userVotes.get(i));
                    }
                }
               voteExist = true;
            }
        }

        if(voteExist == false){
            voteModel.setPost(postModel);
            voteModel.setUser(userModel);

            if(dto.getVoteType()==VoteType.UP_VOTE){
                postModel.setVoteCount(postModel.getVoteCount()+1);
                voteModel.setVoteType(dto.getVoteType());
            }else if(dto.getVoteType()==VoteType.DOWN_VOTE){
                postModel.setVoteCount(postModel.getVoteCount()-1);
                voteModel.setVoteType(dto.getVoteType());
            }
            voteRepository.save(voteModel);
        }

        postRepository.save(postModel);


    }
}
