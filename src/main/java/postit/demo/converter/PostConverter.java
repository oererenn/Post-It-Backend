package postit.demo.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import postit.demo.dto.PostDto;
import postit.demo.model.CommunityModel;
import postit.demo.model.PostModel;
import postit.demo.model.UserModel;
import postit.demo.repository.CommunityRepository;
import postit.demo.repository.PostRepository;
import postit.demo.repository.UserRepository;

import java.time.Instant;

@Component
public class PostConverter {

    private CommunityRepository communityRepository;


    private UserRepository userRepository;
    private PostRepository postRepository;

    @Autowired
    public PostConverter(CommunityRepository communityRepository, UserRepository userRepository, PostRepository postRepository) {
        this.communityRepository = communityRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }


    public PostModel dtoToEntity(PostDto dto){

        CommunityModel communityModel = communityRepository.findById(dto.getCommunityId()).orElseThrow();
        UserModel user = userRepository.findById(dto.getUserId()).orElseThrow();

        PostModel postModel = new PostModel();
        postModel.setUser(user);
        postModel.setCommunity(communityModel);
        postModel.setDescription(dto.getDescription());
        postModel.setTitle(dto.getTitle());
        postModel.setCreatedAt(Instant.now());

return postModel;
    }

    public PostModel dtoToEntityUpdate(PostDto dto, Long id){

        PostModel postModel = postRepository.findById(id).orElseThrow();
        postModel.setDescription(dto.getDescription());
        postModel.setTitle(dto.getTitle());


        return postModel;
    }
}
